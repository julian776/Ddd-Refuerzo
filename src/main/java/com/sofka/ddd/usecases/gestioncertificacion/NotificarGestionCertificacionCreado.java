package com.sofka.ddd.usecases.gestioncertificacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.ddd.domain.gestioncertificacion.events.GestionCertificacionCreada;

import java.util.List;

public class NotificarGestionCertificacionCreado extends UseCase<TriggeredEvent<GestionCertificacionCreada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<GestionCertificacionCreada> triggeredEvent) {
        var event =  triggeredEvent.getDomainEvent();
        var service = getService(SendEmailService.class).orElseThrow();
        var enviado = service.send(
                "sofka-julian@sofka.com",
                "Se le notifica que el gestor de cetificados ya tiene sus documentos de manera correcta",
                event.getHojaDeVidaId()
        );
        if (!enviado){
            throw new BusinessException(event.aggregateRootId(), "Fallo el envio");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
