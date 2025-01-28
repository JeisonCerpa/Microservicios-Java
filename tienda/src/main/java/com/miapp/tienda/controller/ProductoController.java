package com.miapp.tienda.controller;

import com.miapp.tienda.model.ProductoDTO;
import com.miapp.tienda.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class ProductoController {

    private final ProductoService ProductoService;

    public ProductoController(ProductoService ProductoService) {
        this.ProductoService = ProductoService;
    }

    // Endpoint para obtener productos desde el microservicio de objetos
    @GetMapping("/productos")
    public Mono<List<ProductoDTO>> obtenerProductos() {
        return ProductoService.obtenerProductosDeObjeto();
    }

    // Endpoint para obtener un producto por su ID
    @GetMapping("/productos/{id}")
    public Mono<ProductoDTO> obtenerProductoPorId(@PathVariable Long id) {
        return ProductoService.obtenerProductoPorId(id);
    }
}
