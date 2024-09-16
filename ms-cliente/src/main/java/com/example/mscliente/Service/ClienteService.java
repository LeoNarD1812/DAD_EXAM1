package com.example.mscliente.Service;
import com.example.mscliente.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    public List<com.example.mscliente.entity.Cliente> listar();
    public Cliente guardar(Cliente Cliente);
    public Cliente actualizar(Cliente Cliente);
    public Optional<Cliente> listarPorId(Integer id);
    public void eliminar(Integer id);


}
