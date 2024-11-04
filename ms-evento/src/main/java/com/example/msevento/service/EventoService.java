package com.example.msevento.service;

import com.example.msevento.entity.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoService {
    public List<Evento> listar();
    public Evento guardar(Evento evento);
    public Evento actualizar(Evento evento);
    public Optional<Evento> listarPorId(Integer id);
    public void eliminar(Integer id);


}
