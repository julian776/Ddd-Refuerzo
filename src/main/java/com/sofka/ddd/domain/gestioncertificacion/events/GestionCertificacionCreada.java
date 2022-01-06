package com.sofka.ddd.domain.gestioncertificacion.events;

import com.sofka.ddd.domain.gestioncertificacion.entitys.Certificacion;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;

public class GestionCertificacionCreada extends co.com.sofka.domain.generic.DomainEvent {

    private HojaDeVidaId hojaDeVidaId;
    private Certificacion certificacion;

    public GestionCertificacionCreada(HojaDeVidaId hojaDeVidaId, Certificacion certificacion) {
        super("sofka.gestioncertificacion.creada");
        this.hojaDeVidaId = hojaDeVidaId;
        this.certificacion = certificacion;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }
}
