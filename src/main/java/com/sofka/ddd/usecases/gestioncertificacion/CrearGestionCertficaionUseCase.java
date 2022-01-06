package com.sofka.ddd.usecases.gestioncertificacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.ddd.domain.gestioncertificacion.GestionCertificacion;
import com.sofka.ddd.domain.gestioncertificacion.command.CrearGestionCertificacionCommand;

public class CrearGestionCertficaionUseCase extends UseCase<RequestCommand<CrearGestionCertificacionCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearGestionCertificacionCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var gestionCertificado = new GestionCertificacion(command.getEntityId(), command.getHojaDeVidaId(), command.getCertificacion());
        emit().onResponse(new ResponseEvents(gestionCertificado.getUncommittedChanges()));
    }
}
