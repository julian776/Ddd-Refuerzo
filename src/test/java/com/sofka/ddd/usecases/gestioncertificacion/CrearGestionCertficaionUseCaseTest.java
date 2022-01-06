package com.sofka.ddd.usecases.gestioncertificacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.ddd.domain.experiencia.values.Institucion;
import com.sofka.ddd.domain.experiencia.values.Periodo;
import com.sofka.ddd.domain.gestioncertificacion.command.CrearGestionCertificacionCommand;
import com.sofka.ddd.domain.gestioncertificacion.entitys.Certificacion;
import com.sofka.ddd.domain.gestioncertificacion.entitys.CertificacionId;
import com.sofka.ddd.domain.gestioncertificacion.events.GestionCertificacionCreada;
import com.sofka.ddd.domain.gestioncertificacion.values.GestionCertificacionId;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearGestionCertficaionUseCaseTest {

    @Test
    void crearGestionCertificacion(){
        //arrange
        var certificacion = new Certificacion(new CertificacionId("certificacion"), "name", new Institucion("yyy")
                ,new Periodo("00", "01"));
        var command = new CrearGestionCertificacionCommand(new GestionCertificacionId("xxx"),
                new HojaDeVidaId("hoja"), certificacion );
        var usecase = new CrearGestionCertficaionUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();
        //assert
        var event = (GestionCertificacionCreada) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxx", event.aggregateRootId());
        Assertions.assertEquals("00", event.getCertificacion().getPeriodo().getInicio());
        Assertions.assertEquals("name", event.getCertificacion().getNombre());
    }
}