package edu.pe.cibertec.Evaluacion_final_Pregunta2_resilencia.model;

import lombok.Data;

@Data
public class Restaurante {
    private int id;
    private String nombre;
    private String direccion;

    public Restaurante(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }
}