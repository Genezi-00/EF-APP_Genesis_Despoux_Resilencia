package edu.pe.cibertec.Evaluacion_final_Pregunta2_resilencia.service.impl;

import edu.pe.cibertec.Evaluacion_final_Pregunta2_resilencia.model.Pedido;
import edu.pe.cibertec.Evaluacion_final_Pregunta2_resilencia.service.IRestauranteService;
import edu.pe.cibertec.Evaluacion_final_Pregunta2_resilencia.service.IPedidoService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService implements IPedidoService {

    private final IRestauranteService restauranteService;
    private final List<Pedido> pedidos = new ArrayList<>();
    private int cantidadMaxima = 100;

    public PedidoService(IRestauranteService restauranteService) {
        this.restauranteService = restauranteService;
        pedidos.add(new Pedido(1L, "COD001", "2024-10-01", "Pasaje Uruguay", "936755355", "gene@gmail.com", "Pendiente", "Sin observaciones", 1));
        pedidos.add(new Pedido(2L, "COD002", "2024-10-02", "AV. 2 de mayo", "926675254", "hugito@hotmail.com", "Confirmado", "Sin observaciones", 1));
    }

    @Override
    public Pedido obtenerPedidoPorId(Long id) {
        return pedidos.stream()
                .filter(pedido -> pedido.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    @Override
    @CircuitBreaker(name = "pedidoService", fallbackMethod = "fallbackConfirmarPedido")
    public String confirmarPedido(Long id) {
        if (llamadaAlRestauranteExterna(id)) {
            return "Pedido confirmado por el restaurante";
        } else {
            throw new RuntimeException("Error al confirmar el pedido");
        }
    }

    public String fallbackConfirmarPedido(Long id, Throwable throwable) {
        return "El restaurante no respondió a tiempo, por favor intente más tarde.";
    }

    private boolean llamadaAlRestauranteExterna(Long id) {
        if (Math.random() > 0.5) {
            throw new RuntimeException("En estos momentos estamos tardando en confirmar el pedido, por favor reintente en unos minutos");
        }
        return true;
    }
}