package com.sofka.ddd.domain.gestioncertificacion;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.ddd.domain.gestioncertificacion.entitys.Certificacion;
import com.sofka.ddd.domain.gestioncertificacion.values.GestionCertificacionId;
import com.sofka.ddd.domain.hojavida.HojaDeVidaId;

public class GestionCertificacion extends AggregateEvent<GestionCertificacionId> {

    public GestionCertificacion(GestionCertificacionId entityId, HojaDeVidaId hojaDeVidaId, Certificacion certificacion) {
        super(entityId);
    }
}
