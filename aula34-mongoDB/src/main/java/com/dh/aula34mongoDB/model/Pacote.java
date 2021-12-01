package com.dh.aula34mongoDB.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Document(collection = "pacotes")
public class Pacote implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String codigo;
    private String nome;
    private Estado estado;
    private Destino destino;


}
