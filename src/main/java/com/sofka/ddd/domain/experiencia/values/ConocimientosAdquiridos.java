package com.sofka.ddd.domain.experiencia.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ConocimientosAdquiridos implements ValueObject<ConocimientosAdquiridos> {

    private final String conocimientos;

    public ConocimientosAdquiridos(String conocimientos){

        this.conocimientos = Objects.requireNonNull(conocimientos);
        if (conocimientos.isBlank()){
            throw new IllegalArgumentException("Los conocimientos no pueden estar en blanco");
        }
    }

    @Override
    public ConocimientosAdquiridos value() {
        return this;
    }
}
