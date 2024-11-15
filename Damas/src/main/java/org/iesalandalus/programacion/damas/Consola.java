package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Dama;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;

public class Consola {
    private  Consola(){
    }
    public static void mostrarMenu(){
        // Mostrar el menú de opciones
        System.out.println("----- MENU -----");
        System.out.println("1. Crear dama por defecto");
        System.out.println("2. Crear dama eligiendo el color");
        System.out.println("3. Mover ficha");
        System.out.println("4. Salir");
        System.out.print("Elige una opcion: ");
    }

    public static int elegirOpcionMenu() {
        int opcion;
        do{
            opcion= Entrada.entero();
        }while(opcion < 1 || opcion >4);

       return opcion;
    }
    public static Color elegirColor(){
        Color color;
        int opcion=-1;
        do{
            try{
                System.out.println("1. Dama Blanca.");
                System.out.println("2. Dama Negra.");
                opcion = Entrada.entero();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while (opcion != 1 && opcion !=2);
            color = switch (opcion) {
                case 1 -> Color.BLANCO;
                case 2 -> Color.NEGRO;
                default -> throw new IllegalStateException("Valor no esperado " + opcion);
            };


        return color;
    }

    public static void mostrarMenuDirecciones(){
        System.out.println("1. Noreste.");
        System.out.println("2. Noroeste.");
        System.out.println("3. Sureste.");
        System.out.println("4. Suroeste.");
    }

    public static Direccion elegirDireccion() throws OperationNotSupportedException {
        Direccion direccion;
        int opcion=-1;
        do{
            try{
                System.out.println("Elige una direccion.");
                mostrarMenuDirecciones();
                opcion = Entrada.entero();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }while (opcion <1 || opcion >4);

        direccion = switch (opcion){
            case 1 -> Direccion.NORESTE;
            case 2 -> Direccion.NOROESTE;
            case 3 -> Direccion.SURESTE;
            case 4 -> Direccion.SUROESTE;
            default -> throw new IllegalStateException("Valor no esperado: " + opcion);
        };

        return direccion;
    }
    public static int elegirPasos() {
        int pasos;
            do{
                try{
                System.out.println("Introduzca el número de pasos: ");
                pasos = Entrada.entero();
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException(e.getMessage());
            }
            } while(pasos <1);

            return pasos;
    }
    public static void despedirse(){
        System.out.println("Adiós!");
    }
}
