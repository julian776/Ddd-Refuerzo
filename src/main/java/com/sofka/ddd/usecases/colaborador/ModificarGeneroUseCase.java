package com.sofka.ddd.usecases.colaborador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.colaborador.Colaborador;
import com.sofka.ddd.domain.colaborador.commands.ModificarGeneroCommand;

public class ModificarGeneroUseCase extends UseCase<RequestCommand<ModificarGeneroCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarGeneroCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var colaborador = Colaborador.from(command.getEntityId(), retrieveEvents());
        colaborador.modificarGenero(command.getGenero());
        emit().onResponse(new ResponseEvents(colaborador.getUncommittedChanges()));
    }
}
