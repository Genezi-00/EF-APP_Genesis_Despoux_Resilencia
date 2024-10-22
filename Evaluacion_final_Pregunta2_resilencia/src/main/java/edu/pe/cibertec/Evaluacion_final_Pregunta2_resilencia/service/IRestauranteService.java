package edu.pe.cibertec.Evaluacion_final_Pregunta2_resilencia.service;

import edu.pe.cibertec.Evaluacion_final_Pregunta2_resilencia.model.Restaurante;

import java.util.Optional;

public interface IRestauranteService {
    Optional<Restaurante> obtenerRestaurantePorId(int id);
}