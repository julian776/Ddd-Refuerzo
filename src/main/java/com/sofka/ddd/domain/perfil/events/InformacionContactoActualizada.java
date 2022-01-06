package com.sofka.ddd.domain.perfil.events;

import co.com.sofka.domain.generic.DomainEvent;

public class InformacionContactoActualizada extends DomainEvent{

    private String telefono;
    private String telefonoFamiliar;

    public InformacionContactoActualizada(String telefono, String telefonoFamiliar) {
        super("sofka.perfil.informacionactualizada");
        this.telefono = telefono;
        this.telefonoFamiliar = telefonoFamiliar;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTelefonoFamiliar() {
        return telefonoFamiliar;
    }
}
