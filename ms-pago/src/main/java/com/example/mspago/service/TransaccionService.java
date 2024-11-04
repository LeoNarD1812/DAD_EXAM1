package com.example.mspago.service;

import com.example.mspago.entity.Transaccion;

import java.util.List;
import java.util.Optional;

public interface TransaccionService {
    public List<Transaccion> listar();
    public Transaccion guardar(Transaccion pago);
    public Transaccion actualizar(Transaccion pago);
    public Optional<Transaccion> listarPorId(Integer id);
    public void eliminar(Integer id);
}
