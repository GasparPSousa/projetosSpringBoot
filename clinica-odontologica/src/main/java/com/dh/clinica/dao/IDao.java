package com.dh.clinica.dao;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {

     T salvar(T t);
     Optional<T> buscar(Integer id);
     void remover(Integer id);
     List<T> buscarTodos();
     T atualizar(T t);


}
