package com.sofka.ddd.usecases.gestioncertificacion;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.ddd.domain.experiencia.values.Institucion;
import com.sofka.ddd.domain.experiencia.values.Periodo;
import com.sofka.ddd.domain.gestioncertificacion.entitys.Certificacion;
import com.sofka.ddd.domain.gestioncertificacion.entitys.CertificacionId;
import com.sofka.ddd.domain.gestioncertificacion.events.GestionCertificacionCreada;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificarGestionCertificacionCreadoTest {

    @Mock
    SendEmailService service;

    @Test
    void notificarGestionCertificados(){
        var certificacion = new Certificacion(new CertificacionId("certificacion"), "name", new Institucion("yyy")
                ,new Periodo("00", "01"));
        var event = new GestionCertificacionCreada(new HojaDeVidaId("xxx"), certificacion);
        var usecase = new NotificarGestionCertificacionCreado();
        event.setAggregateRootId("id");
        when(service.send("sofka-julian@sofka.com"
                , "Se le notifica que el gestor de cetificados ya tiene sus documentos de manera correcta"
                ,new HojaDeVidaId("xxx"))).thenReturn(true);
        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(service);
        usecase.addServiceBuilder(builder);


        var events = UseCaseHandler.getInstance().syncExecutor(usecase, new TriggeredEvent<>(event))
                .orElseThrow();
    }
}