package com.sofka.ddd.domain.gestioncertificacion;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.ddd.domain.gestioncertificacion.entitys.Certificacion;
import com.sofka.ddd.domain.gestioncertificacion.events.GestionCertificacionCreada;
import com.sofka.ddd.domain.gestioncertificacion.values.GestionCertificacionId;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;

import java.util.Objects;

public class GestionCertificacion extends AggregateEvent<GestionCertificacionId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected Certificacion certificacion;

    public GestionCertificacion(GestionCertificacionId entityId, HojaDeVidaId hojaDeVidaId, Certificacion certificacion) {
        super(entityId);
        Objects.requireNonNull(hojaDeVidaId);
        Objects.requireNonNull(certificacion);
        appendChange(new GestionCertificacionCreada(hojaDeVidaId, certificacion)).apply();
    }

    private GestionCertificacion(GestionCertificacionId entityId){
        super(entityId);
        subscribe(new GestionCertificacionChange(this));
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }
}
