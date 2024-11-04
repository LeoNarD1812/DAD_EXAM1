package com.example.msevento.service.impl;

import com.example.msevento.service.EventService;
import com.example.msevento.entity.Event;
import com.example.msevento.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventoRepository;

    @Override
    public List<Event> listar() {
        return eventoRepository.findAll();
    }

    @Override
    public Event guardar(Event event) {
        return eventoRepository.save(event);
    }

    @Override
    public Event actualizar(Event event) {
        return eventoRepository.save(event);
    }

    @Override
    public Optional<Event> listarPorId(Integer id) {
        return eventoRepository.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        eventoRepository.deleteById(id);

    }
}
