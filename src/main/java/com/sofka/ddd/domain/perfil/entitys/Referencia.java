package com.sofka.ddd.domain.perfil.entitys;

import co.com.sofka.domain.generic.Entity;
import com.sofka.ddd.domain.colaborador.values.NombreCompleto;
import com.sofka.ddd.domain.perfil.values.ReferenciaId;
import com.sofka.ddd.domain.perfil.values.InformacionContacto;

import java.util.Objects;

public class Referencia extends Entity<ReferenciaId> {

    private InformacionContacto informacionContacto;
    private NombreCompleto nombreCompleto;

    public Referencia(ReferenciaId entityId, InformacionContacto informacionContacto, NombreCompleto nombreCompleto) {
        super(entityId);
        this.informacionContacto = Objects.requireNonNull(informacionContacto);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public void actualizarInformacionContacto(String telefono, String telefonoFamiliar){
        this.informacionContacto = this.informacionContacto.actualizar(telefono, telefonoFamiliar);
    }

    public void actualizarNombreCompleto(String primerNombre, String segundoNombre){
        this.nombreCompleto = this.nombreCompleto.actualizar(primerNombre, segundoNombre);
    }
}
