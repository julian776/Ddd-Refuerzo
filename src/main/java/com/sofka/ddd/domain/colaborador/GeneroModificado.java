package com.sofka.ddd.domain.colaborador;

public class GeneroModificado extends co.com.sofka.domain.generic.DomainEvent {

    private final String genero;

    public GeneroModificado(String genero) {
        super("sofka.colaborador.generomodificado");
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
}
