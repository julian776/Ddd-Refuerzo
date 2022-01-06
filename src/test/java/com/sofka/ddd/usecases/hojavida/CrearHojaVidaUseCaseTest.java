package com.sofka.ddd.usecases.hojavida;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.ddd.domain.hojavida.commands.CrearHojaVidaCommand;
import com.sofka.ddd.domain.hojavida.events.HojaDeVidaCreada;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearHojaVidaUseCaseTest {

    @Test
    void crearHojaVida(){
        //arrange
        var command = new CrearHojaVidaCommand(new HojaDeVidaId("xxx"));
        var usecase = new CrearHojaVidaUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //assert
        HojaDeVidaCreada event = (HojaDeVidaCreada) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxx", event.aggregateRootId());
    }
}