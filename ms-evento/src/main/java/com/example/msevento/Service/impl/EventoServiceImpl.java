package com.example.msevento.Service.impl;

import com.example.msevento.Service.EventoService;
import com.example.msevento.entity.Evento;
import com.example.msevento.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento guardar(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public Evento actualizar(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public Optional<Evento> listarPorId(Integer id) {
        return eventoRepository.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        eventoRepository.deleteById(id);

    }
}
