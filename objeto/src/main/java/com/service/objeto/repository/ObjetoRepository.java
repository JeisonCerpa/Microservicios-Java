package com.service.objeto.repository;

import com.service.objeto.model.Objeto; // Importa tu entidad Objeto
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetoRepository extends JpaRepository<Objeto, Long> {
    // Aquí puedes definir métodos de consulta adicionales si los necesitas
}
