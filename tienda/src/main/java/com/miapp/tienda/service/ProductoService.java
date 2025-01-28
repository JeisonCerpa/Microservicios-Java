package com.miapp.tienda.service;

import com.miapp.tienda.model.ProductoDTO;
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

    private static final String OBJETO_MICROSERVICIO_URL = "http://localhost:8081/api/objetos";


    // Obtener productos de un microservicio externo (según tu configuración actual)
    public Mono<List<ProductoDTO>> obtenerProductosDeObjeto() {
        WebClient webClient = webClientBuilder.baseUrl(OBJETO_MICROSERVICIO_URL).build();
        return webClient.get()
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ProductoDTO>>() {});
    }
}

