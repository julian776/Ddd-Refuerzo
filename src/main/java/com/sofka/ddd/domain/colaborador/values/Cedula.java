package com.sofka.ddd.domain.colaborador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cedula implements ValueObject<String> {

    private final String cedula;

    public Cedula(String cedula){
        this.cedula = Objects.requireNonNull(cedula);
        if(cedula.isBlank()){
            throw new IllegalArgumentException("La cedula no puede estar vacia");
        }
    }

    @Override
    public String value() {
        return this.cedula;
    }
}
