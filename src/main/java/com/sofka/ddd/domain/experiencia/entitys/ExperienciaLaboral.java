package com.sofka.ddd.domain.experiencia.entitys;

import co.com.sofka.domain.generic.Entity;
import com.sofka.ddd.domain.experiencia.values.ConocimientosAdquiridos;
import com.sofka.ddd.domain.experiencia.values.ExperienciaLaboralId;
import com.sofka.ddd.domain.experiencia.values.Institucion;
import com.sofka.ddd.domain.experiencia.values.Periodo;

import java.util.Objects;

public class ExperienciaLaboral extends Entity<ExperienciaLaboralId> {

    private Institucion institucion;
    private Periodo periodo;
    private ConocimientosAdquiridos conocimientosAdquiridos;

    public ExperienciaLaboral(ExperienciaLaboralId entityId, Institucion institucion, Periodo periodo, ConocimientosAdquiridos conocimientosAdquiridos) {
        super(entityId);
        this.institucion = Objects.requireNonNull(institucion);
        this.periodo = Objects.requireNonNull(periodo);
        this.conocimientosAdquiridos = Objects.requireNonNull(conocimientosAdquiridos);
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void actualizarConocimientos(ConocimientosAdquiridos conocimientosAdquiridos){
        this.conocimientosAdquiridos = conocimientosAdquiridos;
    }

    public ConocimientosAdquiridos getConocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
