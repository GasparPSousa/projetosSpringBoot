package com.dh.Dentista.service;

import com.dh.Dentista.domain.Dentista;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DentistaServiceImpl implements DentistaService{


    @Override
    public List<Dentista> listaDentistas() {
        return Arrays.asList(new Dentista("Maria"), new Dentista("João"));
    }
}
