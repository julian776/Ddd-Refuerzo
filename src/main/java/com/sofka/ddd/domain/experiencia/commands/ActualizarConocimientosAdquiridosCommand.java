package com.sofka.ddd.domain.experiencia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.experiencia.values.ConocimientosAdquiridos;
import com.sofka.ddd.domain.experiencia.values.ExperienciaId;

public class ActualizarConocimientosAdquiridosCommand extends Command {

    private final ExperienciaId entityId;
    private final ConocimientosAdquiridos conocimientosAdquiridos;

    public ActualizarConocimientosAdquiridosCommand(ExperienciaId entityId, ConocimientosAdquiridos conocimientosAdquiridos){

        this.entityId = entityId;
        this.conocimientosAdquiridos = conocimientosAdquiridos;
    }

    public ExperienciaId getEntityId() {
        return entityId;
    }

    public ConocimientosAdquiridos getConocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
