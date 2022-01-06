package com.sofka.ddd.domain.gestioneducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.experiencia.values.Institucion;
import com.sofka.ddd.domain.experiencia.values.Periodo;
import com.sofka.ddd.domain.gestioneducacion.values.Estudio;
import com.sofka.ddd.domain.gestioneducacion.values.GestionEducacionId;
import com.sofka.ddd.domain.gestioneducacion.values.Tipo;

public class GestionEducacionCreada extends DomainEvent {
    private final Tipo tipo;
    private final Estudio estudio;
    private final Institucion institucion;
    private final Periodo periodo;

    public GestionEducacionCreada(Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        super("sofka.gestioneducacion.creada");
        this.tipo = tipo;
        this.estudio = estudio;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
