package com.sofka.ddd.usecases.colaborador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.colaborador.commands.ModificarNombreCompletoCommand;
import com.sofka.ddd.domain.colaborador.events.ColaboradorCreado;
import com.sofka.ddd.domain.colaborador.events.NombreCompletoModificado;
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
class ModificarNombreCompletoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarNombre(){
        //arrange

        var hojaVidaId = new HojaDeVidaId("xxx");
        var command = new ModificarNombreCompletoCommand(hojaVidaId, "ppp", "sss");
        var usecase = new ModificarNombreCompletoUseCase();

        when(repository.getEventsBy(any())).thenReturn(events());
        usecase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("Colaborador")
                .syncExecutor(usecase, new RequestCommand<>(command)).orElseThrow();
        //assert
        var event = (NombreCompletoModificado)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxx", event.aggregateRootId());
        Assertions.assertEquals("ppp", event.getPrimerNombre());
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