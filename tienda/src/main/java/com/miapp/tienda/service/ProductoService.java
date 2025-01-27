package com.miapp.tienda.service;

import com.miapp.tienda.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.core.ParameterizedTypeReference;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    // Actualiza la URL a la nueva ruta
    private static final String OBJETO_MICROSERVICIO_URL = "http://localhost:8081/api/objetos";

    public Mono<List<Producto>> obtenerProductosDeObjeto() {
        // Crear un objeto WebClient
        WebClient webClient = webClientBuilder.baseUrl(OBJETO_MICROSERVICIO_URL).build();

        // Realizar la solicitud GET al microservicio de objeto
        return webClient.get()
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Producto>>() {});
    }
}
