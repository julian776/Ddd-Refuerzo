package com.sofka.ddd.domain.perfil.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class InformacionContacto implements ValueObject<InformacionContacto> {

    private String telefono;
    private String telefonoFamiliar;

    public InformacionContacto(String telefono, String telefonoFamiliar){

        this.telefono = Objects.requireNonNull(telefono);
        this.telefonoFamiliar = Objects.requireNonNull(telefonoFamiliar);
        if (telefono.isBlank()){
            throw new IllegalArgumentException("El telefono no puede estar en blanco");
        }
        if (telefonoFamiliar.isBlank()){
            throw new IllegalArgumentException("El telefono de un familiar no puede estar en blanco");
        }
    }

    public String telefono() {
        return telefono;
    }

    public String telefonoFamiliar() {
        return telefonoFamiliar;
    }

    public InformacionContacto actualizar(String telefono, String telefonoFamiliar){
        return new InformacionContacto(telefono, telefonoFamiliar);
    }

    @Override
    public InformacionContacto value() {
        return this;
    }
}
