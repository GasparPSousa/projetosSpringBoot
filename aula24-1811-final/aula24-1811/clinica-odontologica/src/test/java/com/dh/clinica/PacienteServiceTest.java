package com.dh.clinica;


import com.dh.clinica.repository.impl.EnderecoDaoH2;
import com.dh.clinica.repository.impl.PacienteDaoH2;
import com.dh.clinica.model.Endereco;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.service.EnderecoService;
import com.dh.clinica.service.PacienteService;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
@SpringBootTest
public class PacienteServiceTest {
    private static PacienteService pacienteService = new PacienteService(new PacienteDaoH2(new EnderecoDaoH2()));
    private EnderecoService enderecoService = new EnderecoService(new EnderecoDaoH2());

    @BeforeClass
    public static void cargarDataSet() {
        Endereco endereco = new Endereco("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.salvar(new Paciente("Santiago", "Paz", "88888888", new Date(), endereco));
        Endereco endereco1 = new Endereco("Av Avellaneda", "333", "CABA", "Buenos Aires");
        Paciente p1 = pacienteService.salvar(new Paciente("Micaela", "Perez", "99999999", new Date(), endereco));

    }

    @Test
    public void agregarYBuscarPacienteTest() {
        Endereco endereco = new Endereco("Calle", "123", "Temperley", "Buenos Aires");
        Paciente p = pacienteService.salvar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), endereco));

        Assert.assertNotNull(pacienteService.buscar(p.getId()));
    }

    @Test
    public void eliminarPacienteTest() {
        pacienteService.excluir(3);
        Assert.assertTrue(pacienteService.buscar(3).isEmpty());

    }

    @Test
    public void traerTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() == 2);
        System.out.println(pacientes);
    }


}
