package com.sofka.ddd.domain.experiencia.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Institucion implements ValueObject<String> {

    private final String institucion;

    public Institucion(String institucion){
        this.institucion = Objects.requireNonNull(institucion);
        if (institucion.isBlank()){
            throw new IllegalArgumentException("La institucion no puede estar en blanco");
        }
    }

    public String institucion() {
        return institucion;
    }

    public Institucion modificar(String institucion){
        return new Institucion(institucion);
    }

    @Override
    public String value() {
        return this.institucion;
    }
}
