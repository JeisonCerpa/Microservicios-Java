package com.service.objeto.controller;

import com.service.objeto.model.Objeto;
import com.service.objeto.service.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/objetos")
public class ObjetoController {

    @Autowired
    private ObjetoService objetoService;


    @GetMapping
    public List<Objeto> getAllObjetos() {
        return objetoService.getAllObjetos();
    }

    @GetMapping("/{id}")
    public Objeto getObjetoById(@PathVariable Long id) {
        return objetoService.getObjetoById(id);
    }

    @PostMapping
    public Objeto createObjeto(@RequestBody Objeto objeto) {
        return objetoService.createObjeto(objeto);
    }
}
