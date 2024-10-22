package edu.pe.cibertec.Evaluacion_final_Pregunta2_resilencia.model;

import lombok.Data;

@Data
public class Pedido {
    private Long id;
    private String codigo;
    private String fecha;
    private String direccion;
    private String telefono;
    private String email;
    private String estado;
    private String observaciones;
    private int idRestaurante;


    public Pedido(Long id, String codigo, String fecha, String direccion, String telefono, String email, String estado, String observaciones, int idRestaurante) {
        this.id = id;
        this.codigo = codigo;
        this.fecha = fecha;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
        this.observaciones = observaciones;
        this.idRestaurante = idRestaurante;
    }
    public Object getId() {

        return idRestaurante;
    }
}