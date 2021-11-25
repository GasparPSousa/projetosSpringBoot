package com.dh.aula30hql.service;

import com.dh.aula30hql.dao.JogadorDAO;
import com.dh.aula30hql.entities.Equipe;
import com.dh.aula30hql.entities.Jogador;
import com.dh.aula30hql.entities.Treinador;
import com.dh.aula30hql.repository.IEquipeRepository;
import com.dh.aula30hql.repository.IJogadorRepository;
import com.dh.aula30hql.repository.ITreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogadorService {

    @Autowired
    private IJogadorRepository jogadorRepository;

    @Autowired
    private ITreinadorRepository treinadorRepository;

    @Autowired
    private IEquipeRepository equipeRepository;

    public void insert(JogadorDAO jogadorDAO) {
        Treinador treinador_id = treinadorRepository.getById(jogadorDAO.getIdTreinador());
        Equipe equipe_id = equipeRepository.getById(jogadorDAO.getIdEquipe());
        Jogador jogador = new Jogador(
                jogadorDAO.getNome(),
                jogadorDAO.getPosicao(),
                jogadorDAO.getNumero(),
                equipe_id,
                treinador_id

        );

        jogadorRepository.save(jogador);
    }

}
