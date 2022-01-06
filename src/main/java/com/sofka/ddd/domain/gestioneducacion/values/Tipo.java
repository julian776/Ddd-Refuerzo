package com.sofka.ddd.domain.gestioneducacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tipo implements ValueObject<String> {

    private final String tipo;

    public Tipo(String tipo) {
        this.tipo = Objects.requireNonNull(tipo);
        if (tipo.isBlank()) {
            throw new IllegalArgumentException("El tipo no puede estar vacio");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public Tipo modificar(String tipo) {
        return new Tipo(tipo);
    }

    @Override
    public String value() {
        return this.tipo;
    }
}