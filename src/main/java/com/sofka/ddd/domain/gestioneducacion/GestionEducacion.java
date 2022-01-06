package com.sofka.ddd.domain.gestioneducacion;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.ddd.domain.experiencia.values.Institucion;
import com.sofka.ddd.domain.experiencia.values.Periodo;
import com.sofka.ddd.domain.gestioneducacion.entitys.Estudio;
import com.sofka.ddd.domain.gestioneducacion.values.GestionEducacionId;
import com.sofka.ddd.domain.gestioneducacion.values.Tipo;

public class GestionEducacion extends AggregateEvent<GestionEducacionId> {

    protected Tipo tipo;
    protected Estudio estudio;
    protected Institucion institucion;
    protected Periodo periodo;

    public GestionEducacion(GestionEducacionId entityId, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        super(entityId);
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
