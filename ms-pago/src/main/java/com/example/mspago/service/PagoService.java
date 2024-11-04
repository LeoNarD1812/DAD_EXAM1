package com.example.mspago.service;

import com.example.mspago.entity.Pago;

import java.util.List;
import java.util.Optional;

public interface PagoService {
    public List<Pago> listar();
    public Pago guardar(Pago pago);
    public Pago actualizar(Pago pago);
    public Optional<Pago> listarPorId(Integer id);
    public void eliminar(Integer id);
}
