package com.sofka.ddd.domain.gestioneducacion;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.ddd.domain.experiencia.values.Institucion;
import com.sofka.ddd.domain.experiencia.values.Periodo;
import com.sofka.ddd.domain.gestioneducacion.events.GestionEducacionCreada;
import com.sofka.ddd.domain.gestioneducacion.values.Estudio;
import com.sofka.ddd.domain.gestioneducacion.values.GestionEducacionId;
import com.sofka.ddd.domain.gestioneducacion.values.Tipo;

import java.util.Objects;

public class GestionEducacion extends AggregateEvent<GestionEducacionId> {

    protected Tipo tipo;
    protected Estudio estudio;
    protected Institucion institucion;
    protected Periodo periodo;

    public GestionEducacion(GestionEducacionId entityId, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        super(entityId);
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(estudio);
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        appendChange(new GestionEducacionCreada(tipo, estudio, institucion, periodo)).apply();
    }

    private GestionEducacion(GestionEducacionId entityId){
        super(entityId);
        subscribe(new GestionEducacionChange(this));
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
