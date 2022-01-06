package com.sofka.ddd.domain.colaborador.events;

import co.com.sofka.domain.generic.DomainEvent;

public class NombreCompletoModificado extends DomainEvent {
    private final String primerNombre;
    private final String segundoNombre;

    public NombreCompletoModificado(String primerNombre, String segundoNombre) {
        super("sofka.colaborador.nombremodificado");
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }
}
