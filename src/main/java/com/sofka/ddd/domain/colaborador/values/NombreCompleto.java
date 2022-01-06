package com.sofka.ddd.domain.colaborador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCompleto implements ValueObject<NombreCompleto> {

    private final String primerNombre;
    private final String segundoNombre;

    public NombreCompleto(String primerNombre, String segundoNombre){

        this.primerNombre = Objects.requireNonNull(primerNombre);
        this.segundoNombre = Objects.requireNonNull(segundoNombre);
        if (primerNombre.isBlank() || segundoNombre.isBlank()){
            throw new IllegalArgumentException("Ningun nombre puede estar vacio");
        }
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public NombreCompleto modificar(String primerNombre, String segundoNombre){
        return new NombreCompleto(primerNombre, segundoNombre);
    }

    @Override
    public NombreCompleto value() {
        return this;
    }
}
