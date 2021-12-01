package com.dh.aula34mongoDB.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Destino {

    private String rua;
    private String numero;
    private String cidade;
    private String estado;

}
