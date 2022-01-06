package com.sofka.ddd.usecases.experiencia;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.experiencia.commands.ActualizarConocimientosAdquiridosCommand;
import com.sofka.ddd.domain.experiencia.entitys.ExperienciaLaboral;
import com.sofka.ddd.domain.experiencia.events.ExperienciaCreada;
import com.sofka.ddd.domain.experiencia.events.ExperienciaLaboralConocimientosModificacdos;
import com.sofka.ddd.domain.experiencia.values.*;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarConocimientosAdquiridosUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarConocimientos(){
        //arrange
        var command = new ActualizarConocimientosAdquiridosCommand(new ExperienciaId("xxx"), new ConocimientosAdquiridos("saltar"));
        var usecase = new ActualizarConocimientosAdquiridosUseCase();

        //act
        when(repository.getEventsBy(any())).thenReturn(events());
        usecase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("Experiencia")
                .syncExecutor(usecase,  new RequestCommand<>(command));
        //assert
        Assertions.assertEquals("xxx", command.getEntityId().toString());
        Assertions.assertEquals("saltar", command.getConocimientosAdquiridos().getConocimientos());
    }
    private List<DomainEvent> events() {
        var experiencia = new ExperienciaLaboral(new ExperienciaLaboralId("ppp")
                , new Institucion("yyy")
                , new Periodo("00", "01")
                , new ConocimientosAdquiridos("conocimientos"));
        return List.of(new ExperienciaCreada(new HojaDeVidaId("xxx"), experiencia));
    }
}