package com.german.interfacesRepositorio.repositorio;

import com.german.interfacesRepositorio.models.Cliente;
import java.util.List;

public interface OrdenableRepositorio {

    List<Cliente> listar(String campo, Direccion direccion);

}
