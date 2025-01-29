package com.service.objeto.controller;

import com.service.objeto.model.Objeto;
import com.service.objeto.service.ObjetoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Objeto", description = "API para la gestión de objetos")
@RestController
@RequestMapping("/api/objetos")
public class ObjetoController {

    @Autowired
    private ObjetoService objetoService;

    @Operation(summary = "Obtener todos los objetos")
    @GetMapping
    public List<Objeto> getAllObjetos() {
        return objetoService.getAllObjetos();
    }

    @Operation(summary = "Obtener un objeto por ID")
    @GetMapping("/{id}")
    public Objeto getObjetoById(@PathVariable Long id) {
        return objetoService.getObjetoById(id);
    }

    @Operation(summary = "Crear un nuevo objeto")
    @PostMapping
    public Objeto createObjeto(@RequestBody Objeto objeto) {
        return objetoService.createObjeto(objeto);
    }

    @Operation(summary = "Eliminar un objeto por ID")
    @DeleteMapping("/{id}")
    public void deleteObjeto(@PathVariable Long id) {
        objetoService.deleteObjeto(id);
    }
}
