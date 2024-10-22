package edu.pe.cibertec.Evaluacion_final_Pregunta2_resilencia.service;

import edu.pe.cibertec.Evaluacion_final_Pregunta2_resilencia.model.Pedido;

public interface IPedidoService {
    Pedido obtenerPedidoPorId(Long id);
    String confirmarPedido(Long id);
}