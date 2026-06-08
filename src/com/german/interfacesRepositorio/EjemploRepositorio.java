package com.german.interfacesRepositorio;

import com.german.interfacesRepositorio.models.*;
import com.german.interfacesRepositorio.repositorio.*;
import static com.german.interfacesRepositorio.repositorio.Direccion.*;
import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        OrdenablePaginableContableCrudRepositorio repo = new ClienteListRepositorio();
        repo.crear(new Cliente("German","Gonzalez"));
        repo.crear(new Cliente("Geronimo","Sandoval"));
        repo.crear(new Cliente("Alessandro", "Magno"));
        repo.crear(new Cliente("Andres","Perez"));

        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);
        System.out.println("========= paginable =========");
        List<Cliente> paginable = repo.listar(1,3);
        paginable.forEach(System.out::println);
        System.out.println("========= orden Asc =========");
        List<Cliente> ordenAsc = repo.listar("nombre",ASC);
        ordenAsc.forEach(System.out::println);
        System.out.println("========= orden Desc =========");
        List<Cliente> ordenDesc = repo.listar("nombre",DESC);
        ordenDesc.forEach(System.out::println);

        System.out.println("======== Editar =========");
        Cliente actualizadoGer = new Cliente("German","Perez");
        actualizadoGer.setId(1);
        repo.editar(actualizadoGer);
        Cliente german = repo.porId(1);
        System.out.println(german);

        System.out.println("======== Eliminar =========");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);
        System.out.println("======== Total de Registros =========");
        System.out.println("Total de registros: " + repo.total());
    }
}
