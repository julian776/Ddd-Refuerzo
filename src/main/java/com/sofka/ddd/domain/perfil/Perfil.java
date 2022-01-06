package com.sofka.ddd.domain.perfil;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.ddd.domain.hojavida.HojaDeVidaId;

import java.util.List;

public class Perfil extends AggregateEvent<HojaDeVidaId> {

    public Perfil(HojaDeVidaId entityId, InformacionContacto informacionContacto, FotoPerfil fotoPerfil, List<Referencia> referencias) {
        super(entityId);
    }
}
