package com.sofka.ddd.domain.colaborador.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;

public class ModificarGeneroCommand extends Command {

    private final HojaDeVidaId entityId;
    private final String genero;

    public ModificarGeneroCommand(HojaDeVidaId entityId, String genero){
        this.entityId = entityId;
        this.genero = genero;
    }

    public HojaDeVidaId getEntityId() {
        return entityId;
    }

    public String getGenero() {
        return genero;
    }
}
