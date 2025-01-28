package com.miapp.tienda;

import com.miapp.tienda.model.ProductoDTO;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TiendaApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Disabled
    @Test
    void obtenerProductos() {
        // Hacemos una solicitud GET a /productos
        webTestClient.get().uri("/productos")
                .exchange()
                .expectStatus().isOk()  // Esperamos que el status sea OK
                .expectHeader().contentType("application/json")  // Esperamos que el contenido sea JSON
                .expectBodyList(ProductoDTO.class)  // Esperamos que el cuerpo sea una lista de productos
                .consumeWith(response -> {
                    List<ProductoDTO> productos = response.getResponseBody();
                    // Verificamos que la lista no esté vacía
                    assert productos != null && productos.size() > 0;
                });
    }
}
