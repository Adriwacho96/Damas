package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;

public class Dama {
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial=false;

    public Dama(){
        setColor(Color.BLANCO);
        posicion = crearPosicionInicial();
        esDamaEspecial = false;
    }
    public Dama (Color color){
        if(color == Color.BLANCO){
            setColor(color);
            esDamaEspecial=false;
            crearPosicionInicial();
        }
        if(color == Color.NEGRO){
            setColor(color);
            esDamaEspecial=false;
            crearPosicionInicial();

        }
    }
    public Color getColor() {
        return color;
    }

    private void setColor(Color color) {
        if(color != Color.BLANCO && color!=Color.NEGRO){
            throw new IllegalArgumentException("El color no es el esperado.");
        }
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }


    public void mover(Direccion direccion,int pasos) throws OperationNotSupportedException{

        int nuevaFila = posicion.getFila();
        int nuevaColumna = posicion.getColumna();
        if(direccion == null){
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        }
        if(pasos <1){
            throw new IllegalArgumentException("ERROR: Los pasos no pueden ser menor a 1.");
        }

        if(!esDamaEspecial){
            if(color == Color.BLANCO){
                if(pasos != 1){
                        throw new IllegalArgumentException("Los pasos no pueden ser distintos de 1");
                }
                if(direccion == Direccion.SURESTE || direccion == Direccion.SUROESTE){
                    throw new IllegalArgumentException("Las direccion no es la correcta.");
                }
            }
            if (color==Color.NEGRO){
                if(pasos != 1){
                    throw new IllegalArgumentException("Los pasos no pueden ser distintos de 1");
                }
                if(direccion != Direccion.SURESTE && direccion != Direccion.SUROESTE){
                    throw new IllegalArgumentException("Las direccion no es la correcta.");
                }
            }
        }



        switch (direccion){
            case NORESTE :
                nuevaFila+=pasos;
                nuevaColumna+=pasos;
                break;
            case NOROESTE:
                nuevaFila+=pasos;
                nuevaColumna-=pasos;
                break;
            case SURESTE:
                nuevaFila-=pasos;
                nuevaColumna+=pasos;
                break;
            case SUROESTE:
                nuevaFila-=pasos;
                nuevaColumna-=pasos;
                break;
        }
        posicion = new Posicion(nuevaFila,(char)nuevaColumna);
        if(color  == Color.BLANCO && nuevaFila == 8){
            esDamaEspecial=true;
        }

        if(color == Color.NEGRO && nuevaFila == 1){
            esDamaEspecial=true;
        }
    }
    private Posicion crearPosicionInicial(){
        char valorColumna=0;
        int valorFila=0;
        if(color==Color.BLANCO){
            valorFila =(int) (Math.random() *3)+1;
            if(valorFila == 1 || valorFila == 3){
                valorColumna = (char) ('a' + 2 * (int) (Math.random() * 4)); //Valores impares de columna: A,C,E,G
            }
            if(valorFila == 2){
                valorColumna = (char) ('b' + 2 * (int) (Math.random() * 4)); //Valores pares de columna: B,D,F,H
            }
            }

        if(color==Color.NEGRO){
            valorFila = (int) (Math.random() *3)+6;
            if(valorFila == 6 || valorFila == 8){
                valorColumna=(char) ('b' + 2 * (int) (Math.random() * 4));
            }
            if(valorFila == 7){
                valorColumna = (char) ('a' + 2 * (int) (Math.random() * 4));
            }

        }
        return posicion= new Posicion(valorFila,valorColumna);
    }

    @Override
    public String toString() {
        return "Dama" + " " + color.toString() + ", " + posicion + " , "+esDamaEspecial;
    }
}
