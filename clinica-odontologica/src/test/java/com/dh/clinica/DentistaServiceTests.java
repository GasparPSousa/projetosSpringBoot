package com.dh.clinica;

import com.dh.clinica.dao.configuration.ConfigurationJDBC;
import com.dh.clinica.dao.impl.DentistaDaoH2;
import com.dh.clinica.model.Dentista;
import com.dh.clinica.service.DentistaService;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
@SpringBootTest
public class DentistaServiceTests {

    private static DentistaService dentistaService = new DentistaService(new DentistaDaoH2(new ConfigurationJDBC()));

    @BeforeClass
    public static void cargarDataSet() {
        dentistaService.registrarDentista(new Dentista("Santiago", "Paz", 3455647));


    }

    @Test
    public void guardarOdontologo() {
        Dentista dentista = dentistaService.registrarDentista(new Dentista("Juan", "Ramirez", 348971960));
        Assert.assertTrue(dentista.getId() != null);

    }

    @Test
    public void eliminarPacienteTest() {
        dentistaService.remover(1);
        Assert.assertTrue(dentistaService.buscar(1).isEmpty());

    }

    @Test
    public void traerTodos() {
        List<Dentista> dentistas = dentistaService.buscarTodos();
        Assert.assertTrue(!dentistas.isEmpty());
        Assert.assertTrue(dentistas.size() == 1);
        System.out.println(dentistas);
    }

}
