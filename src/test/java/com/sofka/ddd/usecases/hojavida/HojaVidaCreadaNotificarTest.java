package com.sofka.ddd.usecases.hojavida;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.ddd.domain.hojavida.events.HojaDeVidaCreada;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HojaVidaCreadaNotificarTest {

    @Mock
    NotificarHojaCreadaService service;

    @Test
    void notificarHoja(){
        var event = new HojaDeVidaCreada();
        var usecase = new HojaVidaCreadaNotificar();
        event.setAggregateRootId("xx");

        when(service.notificar(new HojaDeVidaId("xx")
                , "Hoja de vida recibida"))
                .thenReturn("La persona recibio la notificacion con exito");
        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(service);
        usecase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new TriggeredEvent<>(event)).orElseThrow();
    }
}