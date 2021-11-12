package com.dh.aula20.service;

import com.dh.aula20.domain.Paciente;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

@Service
public class OdontoService {

    private static Map<Integer, Paciente> mapa = new HashMap<>();

    private static String[] nomes = {
            "Antonio", "Marta", "Bianca", "Creuza", "Patrick",
            "Jonas", "Paula", "Ana", "Fernanda", "Patrícia"
    };

    private static String[] sobrenomes = {
            "Morais", "Silveira", "Andrade", "Oliveira", "Bueno",
            "Martinelli", "Souza", "Sauro", "De Sá", "Gomes"
    };

    public Paciente criarPaciente() {
        Random random = new Random();
        int upperbound = 10;
        String nome = nomes[random.nextInt(upperbound)];
        String sobrenome = sobrenomes[random.nextInt(upperbound)];
        String email = nome.toLowerCase(Locale.ROOT) + sobrenome.toLowerCase(Locale.ROOT) + "@dh.com";
        Integer id = mapa.size() + 1;

        mapa.put(id, new Paciente(nome, sobrenome, email, (random.nextInt(upperbound)) + 18));

        return mapa.get(id);
    }

    public Map<Integer, Paciente> buscarPaciente() {
        return mapa;
    }

    public void deletar(Integer id) {
        mapa.remove(id);
    }
}
