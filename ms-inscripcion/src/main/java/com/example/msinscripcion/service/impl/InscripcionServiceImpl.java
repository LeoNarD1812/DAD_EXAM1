package com.example.msinscripcion.service.impl;

import com.example.msinscripcion.entity.Inscripcion;
import com.example.msinscripcion.feign.ClientFeign;
import com.example.msinscripcion.feign.EventFeign;
import com.example.msinscripcion.repository.InscripcionRepository;
import com.example.msinscripcion.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionServiceImpl implements InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private EventFeign eventFeign;
    @Autowired
    private ClientFeign clientFeign;

    @Override
    public List<Inscripcion> list() {
        return inscripcionRepository.findAll();
    }

    @Override
    public Inscripcion save(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public Optional<Inscripcion> findById(Integer id) {
        Optional<Inscripcion> inscripcion = inscripcionRepository.findById(id);
        inscripcion.get().setClientDto(clientFeign.getById(inscripcion.get().getClientId()).getBody());
        /*for (InscripcionDetail inscripcionDetail : inscripcion.get().getInscripcionDetails()) {
            inscripcionDetail.setProductDto(productFeign.getById(inscripcionDetail.getProductId()).getBody());
        }*/
        /*inscripcion.get().getinscripcionDetails().stream().forEach(inscripcionDetail -> {
            inscripcionDetail.setProductDto(productFeign.getById(inscripcionDetail.getProductId()).getBody());
        });*/
        inscripcion.get().getInscripcionDetalles().forEach(inscripcionDetail -> {
            inscripcionDetail.setEventDto(eventFeign.getById(inscripcionDetail.getEventId()).getBody());
        });
        return inscripcion;
    }

    @Override
    public void delete(Integer id) {
        inscripcionRepository.deleteById(id);
    }

    @Override
    public Inscripcion update(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }
}
