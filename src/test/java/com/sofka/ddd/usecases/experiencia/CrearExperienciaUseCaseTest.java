package com.sofka.ddd.usecases.experiencia;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.ddd.domain.experiencia.commands.CrearExperienciaCommand;
import com.sofka.ddd.domain.experiencia.entitys.ExperienciaLaboral;
import com.sofka.ddd.domain.experiencia.events.ExperienciaCreada;
import com.sofka.ddd.domain.experiencia.values.*;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearExperienciaUseCaseTest {

    @Test
    void crearExperiencia(){
        //arrange
        var experiencia = new ExperienciaLaboral(new ExperienciaLaboralId("ppp")
                , new Institucion("yyy")
        , new Periodo("00", "01")
        , new ConocimientosAdquiridos("conocimientos"));
        var command = new CrearExperienciaCommand(new ExperienciaId("xxx"), new HojaDeVidaId("yyy"), experiencia);
        var usecase = new CrearExperienciaUseCase();
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();
        //assert
        var event = (ExperienciaCreada) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxx", event.aggregateRootId());
        Assertions.assertEquals("yyy", event.getExperienciaLaboral().getInstitucion().institucion());
    }
}