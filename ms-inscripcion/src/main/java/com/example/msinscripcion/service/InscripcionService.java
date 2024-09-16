package com.example.msinscripcion.service;

import com.example.msinscripcion.entity.Inscripcion;

import java.util.List;
import java.util.Optional;

public interface InscripcionService {
    public List<Inscripcion> list();

    public Inscripcion save(Inscripcion inscripcion);

    public Optional<Inscripcion> findById(Integer id);

    public void delete(Integer id);

    public Inscripcion update(Inscripcion inscripcion);
}
