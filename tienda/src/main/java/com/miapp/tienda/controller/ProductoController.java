package com.miapp.tienda.controller;

import com.miapp.tienda.model.ProductoDTO;
import com.miapp.tienda.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@Tag(name = "Productos", description = "API para la gestión de productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Operation(summary = "Obtener todos los productos", description = "Obtiene una lista de todos los productos desde el microservicio de objetos")
    @GetMapping("/productos")
    public Mono<List<ProductoDTO>> obtenerProductos() {
        return productoService.obtenerProductosDeObjeto();
    }

    @Operation(summary = "Obtener producto por ID", description = "Obtiene un producto específico por su ID desde el microservicio de objetos")
    @GetMapping("/productos/{id}")
    public Mono<ProductoDTO> obtenerProductoPorId(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id);
    }
}
