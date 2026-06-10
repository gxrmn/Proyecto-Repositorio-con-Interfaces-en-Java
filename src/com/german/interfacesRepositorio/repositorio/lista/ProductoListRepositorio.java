package com.german.interfacesRepositorio.repositorio.lista;

import com.german.interfacesRepositorio.models.Cliente;
import com.german.interfacesRepositorio.models.Producto;
import com.german.interfacesRepositorio.repositorio.AbstractaListRepositorio;
import com.german.interfacesRepositorio.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {

    @Override
    public void editar(Producto producto) {
        Producto p = this.porId(producto.getId());
        p.setPrecio(producto.getPrecio());
        p.setDescripcion(producto.getDescripcion());
    }

    @Override
    public List<Producto> listar(String campo, Direccion direccion) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);

        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if(direccion == Direccion.ASC){
                resultado = ordenar(campo, a,b);
            }
            else if(direccion == Direccion.DESC){
                resultado = ordenar(campo, b,a);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    public static int ordenar(String campo, Producto a, Producto b){
        int resultado = 0;
        switch (campo){
            case "id" ->
                resultado = a.getId().compareTo(b.getId());
            case "precio" ->
                resultado = a.getPrecio().compareTo(b.getPrecio());
            case "descripcion" ->
                resultado = a.getDescripcion().compareTo(b.getDescripcion());
        }
        return resultado;
    }
}
