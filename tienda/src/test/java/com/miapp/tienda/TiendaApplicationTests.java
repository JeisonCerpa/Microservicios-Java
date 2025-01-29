package com.miapp.tienda;

import com.miapp.tienda.controller.ProductoController;
import com.miapp.tienda.model.ProductoDTO;
import com.miapp.tienda.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class TiendaApplicationTests {

    @Mock
    private ProductoService productoService;

    @InjectMocks
    private ProductoController productoController;

    public TiendaApplicationTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerProductos() {
        List<ProductoDTO> productos = Arrays.asList(
                new ProductoDTO(1L, "Producto 1", "Descripción 1"),
                new ProductoDTO(2L, "Producto 2", "Descripción 2")
        );

        when(productoService.obtenerProductosDeObjeto()).thenReturn(Mono.just(productos));

        Mono<List<ProductoDTO>> resultado = productoController.obtenerProductos();

        StepVerifier.create(resultado)
                .expectNext(productos)
                .verifyComplete();
    }

    @Test
    void testObtenerProductoPorId() {
        ProductoDTO producto = new ProductoDTO(1L, "Producto 1", "Descripción 1");

        when(productoService.obtenerProductoPorId(1L)).thenReturn(Mono.just(producto));

        Mono<ProductoDTO> resultado = productoController.obtenerProductoPorId(1L);

        StepVerifier.create(resultado)
                .expectNext(producto)
                .verifyComplete();
    }
}
