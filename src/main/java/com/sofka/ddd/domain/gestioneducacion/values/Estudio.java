package com.sofka.ddd.domain.gestioneducacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estudio implements ValueObject<String> {

    private String estudio;

    public Estudio(String estudio){
        this.estudio = Objects.requireNonNull(estudio);
        if (estudio.isBlank()){
            throw new IllegalArgumentException("El estudio no puede estar vacio");
        }
    }

    public String getEstudio() {
        return estudio;
    }

    public Estudio modificar(String estudio){
        return new Estudio(estudio);
    }

    @Override
    public String value() {
        return this.estudio;
    }
}
