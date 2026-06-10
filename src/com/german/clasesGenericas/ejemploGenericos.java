package com.german.clasesGenericas;

import com.german.interfacesRepositorio.models.Cliente;
import com.german.interfacesRepositorio.models.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ejemploGenericos {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("Juan", "Lopez"));

        Cliente juan = clientes.iterator().next();

        Cliente[] clientesArray = {new Cliente("Capi","Pérez"),
                new Cliente("Papastadopulus", "Jose"), new Cliente("Roberto", "Romero")};

        Integer[] numerosArray = {1,2,3,4,5};

        List<Cliente> clientesLista = fromArraytoList(clientesArray);
        List<Integer> numerosLista = fromArraytoList(numerosArray);

        clientesLista.forEach(System.out::println);
        numerosLista.forEach(System.out::println);

        List<String> nombres = fromArraytoList(new String[]{"Ana", "Tao", "Karla", "Cata"}, numerosArray);

        List<ClientePremium> clientePremiums = fromArraytoList(
                new ClientePremium[]{
                        new ClientePremium("sturridge","Traore"), new ClientePremium("Paquiño","Rojas"), new ClientePremium("Pablito", "Hash")
                });
        clientePremiums.forEach(System.out::println);
        System.out.println();
        imprimirClientes(clientes);
        imprimirClientes(clientesLista);
        imprimirClientes(clientePremiums);

        System.out.println("Maximo de 3, 12, 2 es: " + mayor(3,12,2));
        System.out.println("Maximo de manzana, platano y zanahoria es: " + mayor("manzana", "platano", "zanahoria"));

    }

    public static <T> List<T> fromArraytoList(T[] t){
        return Arrays.asList(t);
    }

    public static <T extends Number> List<T> fromArraytoList(T[] t){
        return Arrays.asList(t);
    }

    public static <T extends Cliente> List<T> fromArraytoList(T[] t){
        return Arrays.asList(t);
    }

    public static <T,G> List<T> fromArraytoList(T[] t, G[] g){
        System.out.println("\nImprimiendo desde el metodo static");
        for(G num : g){
            System.out.println(num);
        }
        return Arrays.asList(t);
    }

    public static void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T mayor(T a, T b, T c){
        T max = a;
        if(b.compareTo(max) > 0){
            max = b;
        }
        if(c.compareTo(max) > 0){
            max = c;
        }
        return max;
    }

}
