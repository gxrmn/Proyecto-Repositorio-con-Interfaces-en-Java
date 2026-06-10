package com.german.interfacesRepositorio.repositorio;

public interface OrdenablePaginableContableCrudRepositorio<T> extends ContableRepositorio, CrudRepositorio<T>,
        PaginableRepositorio<T>, OrdenableRepositorio<T>{
}
