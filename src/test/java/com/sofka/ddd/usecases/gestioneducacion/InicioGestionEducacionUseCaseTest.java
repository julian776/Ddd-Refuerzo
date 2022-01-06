package com.sofka.ddd.usecases.gestioneducacion;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.ddd.domain.experiencia.values.Institucion;
import com.sofka.ddd.domain.experiencia.values.Periodo;
import com.sofka.ddd.domain.gestioneducacion.events.GestionEducacionCreada;
import com.sofka.ddd.domain.gestioneducacion.values.Estudio;
import com.sofka.ddd.domain.gestioneducacion.values.GestionEducacionId;
import com.sofka.ddd.domain.gestioneducacion.values.Tipo;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InicioGestionEducacionUseCaseTest {

    @Mock
    IniciarGestionEducaionService service;

    @Test
    void inciarGestionEducacion(){
        var event = new GestionEducacionCreada(
        new Tipo("desarrollo")
        , new Estudio("FullStack")
        , new Institucion("Sofka")
        , new Periodo("00", "01"));
        event.setAggregateRootId("xxx");
        var usecase = new InicioGestionEducacionUseCase();

        lenient().when(service.inciarProceso(new Institucion("Sofka"), "Nos complace iniciar el proceso, esperamos que sea  un periodo de desarrollo y crecimiento mutuo")).thenReturn(true);
        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(service);
        usecase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new TriggeredEvent<>(event)).orElseThrow();
    }
}