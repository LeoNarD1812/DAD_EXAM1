package com.example.mspago.service.impl;

import com.example.mspago.entity.Transaccion;
import com.example.mspago.repository.TransaccionRepository;
import com.example.mspago.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class TransaccionServiceimpl implements TransaccionService {
    @Autowired
    private TransaccionRepository pagoRepository;

    @Override
    public List<Transaccion> listar() { return pagoRepository.findAll(); }

    @Override
    public Transaccion guardar(Transaccion pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public Transaccion actualizar(Transaccion pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public Optional<Transaccion> listarPorId(Integer id) {
        return pagoRepository.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        pagoRepository.deleteById(id);

    }
}
