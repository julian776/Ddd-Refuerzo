package com.sofka.ddd.domain.colaborador;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.ddd.domain.colaborador.events.ColaboradorCreado;
import com.sofka.ddd.domain.colaborador.events.NombreCompletoModificado;

public class ColaboradorChange extends EventChange {
    public ColaboradorChange(Colaborador colaborador) {
        apply((ColaboradorCreado event) -> {
            colaborador.fechaNacimiento = event.getFechaNacimiento();
            colaborador.nombreCompleto = event.getNombreCompleto();
            colaborador.cedula = event.getCedula();
            colaborador.genero = event.getGenero();
            colaborador.area = event.getArea();
            colaborador.perfil = event.getPerfil();
        });

        apply((NombreCompletoModificado event) -> {
            colaborador.nombreCompleto = colaborador.nombreCompleto.actualizar(event.getPrimerNombre(), event.getSegundoNombre());
        });

        apply((GeneroModificado event) -> {
            colaborador.genero = colaborador.genero.actualizar(event.getGenero());
        });
    }
}
