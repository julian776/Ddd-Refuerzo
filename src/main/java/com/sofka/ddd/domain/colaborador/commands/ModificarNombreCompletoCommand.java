package com.sofka.ddd.domain.colaborador.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;

public class ModificarNombreCompletoCommand extends Command {

    private final HojaDeVidaId entityId;
    private final String primerNombre;
    private final String segundoNombre;

    public ModificarNombreCompletoCommand(HojaDeVidaId entityId, String primerNombre, String segundoNombre){

        this.entityId = entityId;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
    }

    public HojaDeVidaId getEntityId() {
        return entityId;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }
}
