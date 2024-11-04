package com.example.msevento.service;

import com.example.msevento.entity.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    public List<Event> listar();
    public Event guardar(Event event);
    public Event actualizar(Event event);
    public Optional<Event> listarPorId(Integer id);
    public void eliminar(Integer id);


}
