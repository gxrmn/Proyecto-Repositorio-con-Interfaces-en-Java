package com.german.interfacesRepositorio.repositorio;

import com.german.interfacesRepositorio.models.Cliente;

import java.util.List;

public interface PaginableRepositorio {

    List<Cliente> listar(int desde, int hasta);

}
