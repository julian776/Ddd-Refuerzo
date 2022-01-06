package com.sofka.ddd.domain.gestioncertificacion.command;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.gestioncertificacion.entitys.Certificacion;
import com.sofka.ddd.domain.gestioncertificacion.values.GestionCertificacionId;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;

public class CrearGestionCertificacionCommand extends Command {

    private final GestionCertificacionId entityId;
    private final HojaDeVidaId hojaDeVidaId;
    private final Certificacion certificacion;

    public CrearGestionCertificacionCommand(GestionCertificacionId entityId, HojaDeVidaId hojaDeVidaId, Certificacion certificacion){

        this.entityId = entityId;
        this.hojaDeVidaId = hojaDeVidaId;
        this.certificacion = certificacion;
    }

    public GestionCertificacionId getEntityId() {
        return entityId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }
}
