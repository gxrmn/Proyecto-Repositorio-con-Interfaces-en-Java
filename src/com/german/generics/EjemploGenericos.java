package com.german.generics;

import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.add(new Animal("Juan","Caballo"));
        transporteCaballos.add(new Animal("Jose", "Caballo"));
        transporteCaballos.add(new Animal("Torcha", "Caballo"));
        transporteCaballos.add(new Animal("Manjo", "Caballo"));
        transporteCaballos.add(new Animal("Teterete", "Caballo"));
        transporteCaballos.add(new Animal("Veloz", "Caballo"));
        imprimir(transporteCaballos);

        Camion<Automovil> transporteAutos = new Camion<>(4);
        transporteAutos.add(new Automovil("Ford"));
        transporteAutos.add(new Automovil("Ferrari"));
        transporteAutos.add(new Automovil("Nissan"));
        transporteAutos.add(new Automovil("Chevrolet"));
        transporteAutos.add(new Automovil("Lamboghini"));
        imprimir(transporteAutos);

        Camion<Maquinaria> transporteMaquinas = new Camion<>(3);
        transporteMaquinas.add(new Maquinaria("Grua"));
        transporteMaquinas.add(new Maquinaria("Tractor"));
        transporteMaquinas.add(new Maquinaria("Chapeadora"));
        imprimir(transporteMaquinas);

    }

    public static <T> void imprimir(Camion<T> c){
        for(T a : c){
            if(a instanceof Animal) {
                System.out.println(((Animal) a).getNombre());
            }
            else if(a instanceof Automovil){
                System.out.println(((Automovil) a).getMarca());
            }
            else if(a instanceof Maquinaria){
                System.out.println(((Maquinaria) a).getTipo());
            }
        }
    }
}
