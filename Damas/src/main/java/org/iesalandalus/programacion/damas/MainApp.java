package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.damas.modelo.Dama;
import org.iesalandalus.programacion.damas.Consola;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
    public static void main(String[] args) throws OperationNotSupportedException {
        int opcion;
        do{
            Consola.mostrarMenu();
            opcion=Consola.elegirOpcionMenu();
            switch (opcion){
                case 1:
                    crearDamaDefecto();
                    mostrarDama();
                    break;
                case 2:
                    try {
                        crearDamaColor();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    mostrarDama();
                    break;
                case 3:
                    try {
                        mover();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (OperationNotSupportedException e) {
                        System.out.println("Operación no soportada: " + e.getMessage());
                    }
                    break;
                case 4: Consola.despedirse();
                default:
                    System.out.println("Opción no válida, intenta nuevamente.");
            }
        }while (opcion!=4);

    }
	static Dama dama;
    private static void crearDamaDefecto(){
    dama = new Dama();
    }
    private static void crearDamaColor() throws OperationNotSupportedException {
    dama = new Dama(Consola.elegirColor());
    }
    private static void mover() throws OperationNotSupportedException {
            if(dama == null){
                throw new OperationNotSupportedException("La dama no puede ser nula.");
            }
            Direccion direccion = Consola.elegirDireccion();
            int pasos=Consola.elegirPasos();
            dama.mover(direccion,pasos);
            mostrarDama();
    }
    private static void mostrarDama(){
        System.out.println(dama);
    }
}
