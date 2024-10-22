package edu.pe.cibertec.Evaluacion_final_Pregunta2_resilencia.controller;

import edu.pe.cibertec.Evaluacion_final_Pregunta2_resilencia.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @PostMapping("/confirmar/{id}")
    public String confirmarPedido(@PathVariable Long id) {
        return pedidoService.confirmarPedido(id);
    }
}