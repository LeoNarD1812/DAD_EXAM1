package com.example.mspago.service;

import com.example.mspago.entity.Transaccion;

import java.util.List;
import java.util.Optional;

public interface TransaccionService {
    public List<Transaccion> list();

    public Transaccion save(Transaccion transaccion);

    public Optional<Transaccion> findById(Integer id);

    public void delete(Integer id);

    public Transaccion update(Transaccion transaccion);
}
