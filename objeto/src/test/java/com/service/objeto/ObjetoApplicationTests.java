package com.service.objeto;

import com.service.objeto.model.Objeto;
import com.service.objeto.repository.ObjetoRepository;
import com.service.objeto.service.ObjetoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ObjetoApplicationTests {

    @Mock
    private ObjetoRepository objetoRepository;

    @InjectMocks
    private ObjetoService objetoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testGetAllObjetos() {
        Objeto objeto1 = new Objeto();
        objeto1.setId(1L);
        objeto1.setNombre("Objeto 1");
        objeto1.setDescripcion("Descripción 1");

        Objeto objeto2 = new Objeto();
        objeto2.setId(2L);
        objeto2.setNombre("Objeto 2");
        objeto2.setDescripcion("Descripción 2");

        when(objetoRepository.findAll()).thenReturn(Arrays.asList(objeto1, objeto2));

        List<Objeto> objetos = objetoService.getAllObjetos();

        assertEquals(2, objetos.size());
        verify(objetoRepository, times(1)).findAll();
    }

    @Test
    void testGetObjetoById() {
        Objeto objeto = new Objeto();
        objeto.setId(1L);
        objeto.setNombre("Objeto 1");
        objeto.setDescripcion("Descripción 1");

        when(objetoRepository.findById(1L)).thenReturn(Optional.of(objeto));

        Objeto foundObjeto = objetoService.getObjetoById(1L);

        assertEquals("Objeto 1", foundObjeto.getNombre());
        verify(objetoRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateObjeto() {
        Objeto objeto = new Objeto();
        objeto.setNombre("Objeto 1");
        objeto.setDescripcion("Descripción 1");

        when(objetoRepository.save(objeto)).thenReturn(objeto);

        Objeto createdObjeto = objetoService.createObjeto(objeto);

        assertEquals("Objeto 1", createdObjeto.getNombre());
        verify(objetoRepository, times(1)).save(objeto);
    }

    @Test
    void testDeleteObjeto() {
        Long objetoId = 1L;

        doNothing().when(objetoRepository).deleteById(objetoId);

        objetoService.deleteObjeto(objetoId);

        verify(objetoRepository, times(1)).deleteById(objetoId);
    }
}
