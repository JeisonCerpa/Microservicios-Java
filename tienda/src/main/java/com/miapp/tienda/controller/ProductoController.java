package com.miapp.tienda.controller;

import com.miapp.tienda.model.Producto;
import com.miapp.tienda.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.util.List;

@RestController
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public Mono<List<Producto>> obtenerProductos() {
        return productoService.obtenerProductosDeObjeto();
    }

    
}
