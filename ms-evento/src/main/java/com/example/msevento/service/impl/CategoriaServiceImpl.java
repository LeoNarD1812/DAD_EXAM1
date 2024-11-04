package com.example.msevento.service.impl;

import com.example.msevento.service.CategoriaService;
import com.example.msevento.entity.Categoria;
import com.example.msevento.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> list() { return categoriaRepository.findAll();    }

    @Override
    public Optional<Categoria> findById(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria save(Categoria category) {
        return categoriaRepository.save(category);
    }

    @Override
    public Categoria update(Categoria category) {
        return categoriaRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
