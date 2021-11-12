package com.dh.aula20.service;

import com.dh.aula20.domain.Dentista;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

@Service
public class DentistaService {

    private static Map<Integer, Dentista> mapaDentista = new HashMap<>();

    private static String[] nomesDentistas = {
            "Gaspar", "Mariana", "Nelson", "Jardel", "Nathalia",
            "Larissa", "Jennifer", "Caio", "Fernando", "Gustavo"
    };

    private static String[] sobrenomesDentistas = {
            "Sousa", "Pacheco", "Kobayashi", "Oliveira", "Vieira",
            "Nunes", "Mayumi", "Castro", "Victor", "Bittencourt"
    };

    private static String[] matriculaDentista = {
            "1111", "1112", "1113", "1114", "1115",
            "1116", "1117", "1118", "1119", "1110"
    };

    public Dentista criarDentista() {
        Random random = new Random();
        int upperbound = 10;
        String nome = nomesDentistas[random.nextInt(upperbound)];
        String sobrenome = sobrenomesDentistas[random.nextInt(upperbound)];
        String matricula = matriculaDentista[random.nextInt(upperbound)];
        String email = nome.toLowerCase(Locale.ROOT) + "." + sobrenome.toLowerCase(Locale.ROOT) + "@dh.com";
        Integer idDentista = mapaDentista.size() + 1;

        mapaDentista.put(idDentista, new Dentista(nome, sobrenome, matricula, email, (random.nextInt(upperbound)) + 18));

        return mapaDentista.get(idDentista);
    }

    public Map<Integer, Dentista> buscarDentista() {
        return mapaDentista;
    }

    public void deletar(Integer idDentista) {
        mapaDentista.remove(idDentista);
    }
}
