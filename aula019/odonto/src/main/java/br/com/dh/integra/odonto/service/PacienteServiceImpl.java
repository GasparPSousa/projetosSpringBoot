package br.com.dh.integra.odonto.service;


import br.com.dh.integra.odonto.domain.Endereco;
import br.com.dh.integra.odonto.domain.Paciente;
import br.com.dh.integra.odonto.util.UtilDate;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PacienteServiceImpl implements IPacienteService{

    private Endereco endereco01 = new Endereco(
            "Av. Mostadeiro", "1255", "Porto Alegre", "RS");

    private Paciente paciente01 = new Paciente(
            1, "Fernandão",  "fernando.inter@internacional.com", "11111111",
            UtilDate.dateToTimestamp(new Date()), endereco01);




    private Endereco endereco02 = new Endereco("Av. Brasil", "630", "Pelotas", "RS" );

    private Paciente paciente02 = new Paciente(2, "Taison", "taison10@internacional.com", "22222222",
            UtilDate.dateToTimestamp(new Date()), endereco02);





    @Override
    public List<Paciente> listPaciente() {
        ArrayList<Paciente> paciente = new ArrayList<>();
        paciente.add(paciente01);
        paciente.add(paciente02);

//        for (Paciente p : paciente) {
//            System.out.println(p);
//        }
//
//        return null;
        return paciente;
    }

    @Override
    public Paciente buscaPorEmail(String email) {
        if (email.equalsIgnoreCase(paciente01.getEmail())) {
            return paciente01;
        } else if(email.equalsIgnoreCase(paciente02.getEmail())){
            return paciente02;
        }

        return null;
    }
}
