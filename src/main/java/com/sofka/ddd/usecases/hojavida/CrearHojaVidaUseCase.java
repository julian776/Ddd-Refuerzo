package com.sofka.ddd.usecases.hojavida;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.hojavida.HojaDeVida;
import com.sofka.ddd.domain.hojavida.commands.CrearHojaVidaCommand;

public class CrearHojaVidaUseCase extends UseCase<RequestCommand<CrearHojaVidaCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearHojaVidaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var hojaVida = new HojaDeVida(command.getHojaDeVidaId());
        emit().onResponse(new ResponseEvents(hojaVida.getUncommittedChanges()));
    }
}
