package com.sofka.ddd.usecases.colaborador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.colaborador.Colaborador;
import com.sofka.ddd.domain.colaborador.commands.ModificarNombreCompletoCommand;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;

public class ModificarNombreCompletoUseCase extends UseCase<RequestCommand<ModificarNombreCompletoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarNombreCompletoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var colaborador = Colaborador.from(command.getEntityId(), retrieveEvents());
        colaborador.modificarNombre(command.getPrimerNombre(), command.getSegundoNombre());
        emit().onResponse(new ResponseEvents(colaborador.getUncommittedChanges()));
    }
}
