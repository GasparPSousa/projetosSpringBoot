package com.dh.aula33mongodb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
@Document(collation = "partidas")
public class Partidas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String status;
    private String resultado;
    private Time timeLocal;
    private Time timeVisitante;


}
