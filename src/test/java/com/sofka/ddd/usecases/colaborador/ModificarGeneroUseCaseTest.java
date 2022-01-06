package com.sofka.ddd.usecases.colaborador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.colaborador.GeneroModificado;
import com.sofka.ddd.domain.colaborador.commands.ModificarGeneroCommand;
import com.sofka.ddd.domain.colaborador.events.ColaboradorCreado;
import com.sofka.ddd.domain.colaborador.values.Cedula;
import com.sofka.ddd.domain.colaborador.values.FechaNacimiento;
import com.sofka.ddd.domain.colaborador.values.Genero;
import com.sofka.ddd.domain.colaborador.values.NombreCompleto;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;
import com.sofka.ddd.domain.perfil.Perfil;
import com.sofka.ddd.domain.perfil.values.FotoPerfil;
import com.sofka.ddd.domain.perfil.values.InformacionContacto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModificarGeneroUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void modificarGenero(){

        HojaDeVidaId entityId = new HojaDeVidaId("xxxx");
        var command = new ModificarGeneroCommand(entityId, "F");
        var usecase = new ModificarGeneroUseCase();

        when(repository.getEventsBy(any())).thenReturn(events());
        usecase.addRepository(repository);
        var events = UseCaseHandler.getInstance().setIdentifyExecutor("Colaborador")
                .syncExecutor(usecase, new RequestCommand<>(command)).orElseThrow();

        var event = (GeneroModificado) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("F", event.getGenero());
        Mockito.verify(repository).getEventsBy(any());
    }

    private List<DomainEvent> events() {
        return List.of(new ColaboradorCreado(new FechaNacimiento("00/00/00")
                ,new NombreCompleto("p", "s")
                ,new Cedula("44")
                , new Genero("M")
                , "cc"
                , new Perfil(new HojaDeVidaId("xxx")
                ,new InformacionContacto("1", "001")
                , new FotoPerfil("./", "2012")
                , new ArrayList<>())
        ));
    }

}