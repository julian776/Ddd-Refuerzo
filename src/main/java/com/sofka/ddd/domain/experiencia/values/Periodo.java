package com.sofka.ddd.domain.experiencia.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Periodo implements ValueObject<Periodo> {

    private final String inicio;
    private final String finalizacion;

    public Periodo(String inicio, String finalizacion){

        this.inicio = Objects.requireNonNull(inicio);
        this.finalizacion = Objects.requireNonNull(finalizacion);
        if (inicio.isBlank() || finalizacion.isBlank()){
            throw new IllegalArgumentException("Las fechas deben ser validas");
        }
    }

    public String getInicio() {
        return inicio;
    }

    public String getFinalizacion() {
        return finalizacion;
    }

    public Periodo modificar(String inicio, String finalizacion){
        return new Periodo(inicio, finalizacion);
    }

    @Override
    public Periodo value() {
        return this;
    }
}
