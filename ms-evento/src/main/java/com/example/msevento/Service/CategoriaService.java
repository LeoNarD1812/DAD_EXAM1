package com.example.msevento.Service;

import com.example.msevento.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> list();
    Optional<Categoria> findById(Integer id);
    Categoria save(Categoria categoria);
    Categoria update(Categoria categoria);
    void delete(Integer id);
}
