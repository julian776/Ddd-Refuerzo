package com.sofka.ddd.domain.colaborador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FechaNacimiento implements ValueObject<String> {

    private final String fechaNacimiento;

    public FechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = Objects.requireNonNull(fechaNacimiento);
        if (fechaNacimiento.isBlank()){
            throw new IllegalArgumentException("La fecha de nacimiento no puede estar vacia");
        }
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public FechaNacimiento modificar(String nuevaFecha){
        return new FechaNacimiento(nuevaFecha);
    }

    @Override
    public String value() {
        return this.fechaNacimiento;
    }
}
