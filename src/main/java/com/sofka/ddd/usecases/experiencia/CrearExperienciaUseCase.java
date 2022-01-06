package com.sofka.ddd.usecases.experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.experiencia.Experiencia;
import com.sofka.ddd.domain.experiencia.commands.CrearExperienciaCommand;
import com.sofka.ddd.domain.experiencia.values.ExperienciaId;

public class CrearExperienciaUseCase extends UseCase<RequestCommand<CrearExperienciaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearExperienciaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var experiencia = new Experiencia(command.getEntityId(), command.getHojaDeVidaId(), command.getExperienciaLaboral());
        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }
}
