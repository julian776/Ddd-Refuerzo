package com.sofka.ddd.usecases.gestioneducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.ddd.domain.gestioneducacion.events.GestionEducacionCreada;

import java.util.List;

public class InicioGestionEducacionUseCase extends UseCase<TriggeredEvent<GestionEducacionCreada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<GestionEducacionCreada> triggeredEvent) {
        var event = triggeredEvent.getDomainEvent();
        var service = getService(IniciarGestionEducaionService.class).orElseThrow();
        service.inciarProceso(event.getInstitucion(), "Nos complace iniciar el proceso, esperamos que sea  un periodo de desarrollo y crecimiento mutuo");
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
