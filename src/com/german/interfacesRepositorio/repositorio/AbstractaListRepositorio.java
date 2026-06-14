package com.german.interfacesRepositorio.repositorio;

import com.german.interfacesRepositorio.Excepciones.*;
import com.german.interfacesRepositorio.models.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements OrdenablePaginableContableCrudRepositorio<T> {

    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException{
        if(id == null || id <= 0){
            throw new LecturaAccesoDatoException("Id Invalido debe ser mayor a 0");
        }
        T resultado = null;
        for(T cliente : dataSource){
            if(cliente.getId() != null && cliente.getId().equals(id)){
                resultado = cliente;
            }
        }
        if(resultado == null){
            throw new LecturaAccesoDatoException("No existe un registro con ese id: " + id);
        }
        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException {
        if(t == null){
            throw new EscrituraAccesoDatoException("Error al ingresar un objeto nulo");
        }
        if(dataSource.contains(t)){
            throw new RegistroDuplicadoAccesoDatoException("Ese objeto ya existe en la lista, no puedes duplicarlo");
        }
        this.dataSource.add(t);
    }


    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }

}
