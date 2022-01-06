package com.sofka.ddd.domain.gestioncertificacion;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.ddd.domain.gestioncertificacion.events.GestionCertificacionCreada;

public class GestionCertificacionChange extends EventChange {
    public GestionCertificacionChange(GestionCertificacion gestionCertificacion) {
        apply((GestionCertificacionCreada event)-> {
            gestionCertificacion.hojaDeVidaId = event.getHojaDeVidaId();
            gestionCertificacion.certificacion = event.getCertificacion();
        });
    }
}
