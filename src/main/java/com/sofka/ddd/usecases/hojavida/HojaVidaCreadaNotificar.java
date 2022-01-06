package com.sofka.ddd.usecases.hojavida;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.ddd.domain.hojavida.events.HojaDeVidaCreada;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;

import java.util.List;

public class HojaVidaCreadaNotificar extends UseCase<TriggeredEvent<HojaDeVidaCreada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<HojaDeVidaCreada> triggeredEvent) {
        var event = triggeredEvent.getDomainEvent();
        var service = getService(NotificarHojaCreadaService.class).orElseThrow();
        var response = service.notificar(new HojaDeVidaId(event.aggregateRootId()), "Hoja de vida recibida");
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
