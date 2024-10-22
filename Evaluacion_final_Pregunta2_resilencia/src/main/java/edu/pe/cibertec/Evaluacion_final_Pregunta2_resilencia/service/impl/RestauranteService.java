package edu.pe.cibertec.Evaluacion_final_Pregunta2_resilencia.service.impl;

import edu.pe.cibertec.Evaluacion_final_Pregunta2_resilencia.model.Restaurante;
import edu.pe.cibertec.Evaluacion_final_Pregunta2_resilencia.service.IRestauranteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService implements IRestauranteService {

    private final List<Restaurante> restaurantes = new ArrayList<>();

    public RestauranteService() {
        restaurantes.add(new Restaurante(1, "KFC", "Mall Bellavista"));
        restaurantes.add(new Restaurante(2, "POPEYES", "Minka"));
    }

    @Override
    public Optional<Restaurante> obtenerRestaurantePorId(int id) {
        return restaurantes.stream()
                .filter(restaurante -> restaurante.getId() == id)
                .findFirst();
    }
}