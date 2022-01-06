package com.sofka.ddd.usecases.experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.experiencia.Experiencia;
import com.sofka.ddd.domain.experiencia.commands.ActualizarConocimientosAdquiridosCommand;
import com.sofka.ddd.domain.experiencia.values.ExperienciaId;

public class ActualizarConocimientosAdquiridosUseCase extends UseCase<RequestCommand<ActualizarConocimientosAdquiridosCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarConocimientosAdquiridosCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var experiencia = Experiencia.from(command.getEntityId(), retrieveEvents());
        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }
}
