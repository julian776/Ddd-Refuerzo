package com.sofka.ddd.domain.colaborador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Genero implements ValueObject<String> {

    private final String genero;

    public Genero(String genero){
        this.genero = Objects.requireNonNull(genero);
        if(!(genero.equals("M") || genero.equals("F"))){
            throw new IllegalArgumentException("Solo se admite genero M o F");
        }
    }

    public String genero() {
        return genero;
    }

    public Genero actualizar(String genero){
        return new Genero(genero);
    }

    @Override
    public String value() {
        return this.genero;
    }
}
