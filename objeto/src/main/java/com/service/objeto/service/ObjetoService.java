package com.service.objeto.service;

import com.service.objeto.model.Objeto;
import com.service.objeto.repository.ObjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetoService {

    @Autowired
    private ObjetoRepository objetoRepository;

    public List<Objeto> getAllObjetos() {
        return objetoRepository.findAll();
    }

    public Objeto getObjetoById(Long id) {
        return objetoRepository.findById(id).orElse(null);
    }

    public Objeto createObjeto(Objeto objeto) {
        return objetoRepository.save(objeto);
    }
}
