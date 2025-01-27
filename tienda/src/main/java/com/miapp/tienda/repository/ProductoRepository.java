package com.miapp.tienda.repository;

import com.miapp.tienda.model.Producto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductoRepository extends ReactiveCrudRepository<Producto, Long> {
    // Aquí puedes agregar más métodos si lo necesitas
}
