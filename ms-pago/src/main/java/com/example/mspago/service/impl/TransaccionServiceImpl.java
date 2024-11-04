package com.example.mspago.service.impl;

import com.example.mspago.entity.Transaccion;
import com.example.mspago.feign.ClientFeign;
import com.example.mspago.feign.InscripcionFeign;
import com.example.mspago.repository.TransaccionRepository;
import com.example.mspago.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private InscripcionFeign inscripcionFeign;
    @Autowired
    private ClientFeign clientFeign;

    @Override
    public List<Transaccion> list() {
        return transaccionRepository.findAll();
    }

    @Override
    public Transaccion save(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    @Override
    public Optional<Transaccion> findById(Integer id) {
        Optional<Transaccion> transaccion = transaccionRepository.findById(id);
        transaccion.get().setClientDto(clientFeign.getById(transaccion.get().getClientId()).getBody());
        /*for (TransaccionDetail transaccionDetail : transaccion.get().getTransaccionDetails()) {
            transaccionDetail.setProductDto(productFeign.getById(transaccionDetail.getProductId()).getBody());
        }*/
        /*transaccion.get().getTransaccionDetails().stream().forEach(transaccionDetail -> {
            transaccionDetail.setProductDto(productFeign.getById(transaccionDetail.getProductId()).getBody());
        });*/
        transaccion.get().getTransaccionDetalles().forEach(transaccionDetail -> {
            transaccionDetail.setInscripcionDto(inscripcionFeign.getById(transaccionDetail.getInscripcionId()).getBody());
        });
        return transaccion;
    }

    @Override
    public void delete(Integer id) {
        transaccionRepository.deleteById(id);
    }

    @Override
    public Transaccion update(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }
}
