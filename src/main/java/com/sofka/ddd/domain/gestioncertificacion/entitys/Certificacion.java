package com.sofka.ddd.domain.gestioncertificacion.entitys;

import co.com.sofka.domain.generic.Entity;
import com.sofka.ddd.domain.experiencia.values.Institucion;
import com.sofka.ddd.domain.experiencia.values.Periodo;

public class Certificacion extends Entity<CertificacionId> {

    private String nombre;
    private Institucion institucion;
    private Periodo periodo;

    public Certificacion(CertificacionId entityId, String nombre, Institucion institucion, Periodo periodo) {
        super(entityId);
        this.nombre = nombre;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public String getNombre() {
        return nombre;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
