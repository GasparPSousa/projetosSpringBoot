package com.dh.clinica;

import com.dh.clinica.model.Endereco;
import com.dh.clinica.model.Dentista;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.model.Turno;
import com.dh.clinica.service.DentistaService;
import com.dh.clinica.service.PacienteService;
import com.dh.clinica.service.TurnoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnoServiceTests {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DentistaService dentistaService;
    @Autowired
    private TurnoService turnoService;

    public void cargarDataSet() {
        Endereco endereco = new Endereco("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), endereco));
        this.dentistaService.registrarDentista(new Dentista("Santiago", "Paz", 3455647));
    }
    @Test
    public void altaTurnoTest(){
        this.cargarDataSet();
        turnoService.registrarTurno(new Turno(pacienteService.buscar(1).get(), dentistaService.buscar(1).get(),new Date()));
        Assert.assertNotNull(turnoService.buscar(1));
    }
    @Test
    public void buscarTurnoTest(){
        Assert.assertNotNull(turnoService.buscar(1));
    }
    @Test
    public void eliminarTurnoTest(){
        turnoService.apagar(1);
        Assert.assertFalse(turnoService.buscar(1).isPresent());
    }
}
