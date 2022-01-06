package com.sofka.ddd.domain.perfil;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;
import com.sofka.ddd.domain.perfil.entitys.Referencia;
import com.sofka.ddd.domain.perfil.events.InformacionContactoActualizada;
import com.sofka.ddd.domain.perfil.values.FotoPerfil;
import com.sofka.ddd.domain.perfil.values.InformacionContacto;

import java.util.List;
import java.util.Objects;

public class Perfil extends AggregateEvent<HojaDeVidaId> {

    protected InformacionContacto informacionContacto;
    protected FotoPerfil fotoPerfil;
    protected List<Referencia> referencias;

    public Perfil(HojaDeVidaId entityId, InformacionContacto informacionContacto, FotoPerfil fotoPerfil, List<Referencia> referencias) {
        super(entityId);
        this.informacionContacto = informacionContacto;
        this.fotoPerfil = fotoPerfil;
        this.referencias = Objects.requireNonNull(referencias);
    }

    private Perfil(HojaDeVidaId entityId){
        super(entityId);
        subscribe(new PerfilChange(this));
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }

    public FotoPerfil getFotoPerfil() {
        return fotoPerfil;
    }

    public List<Referencia> getReferencias() {
        return referencias;
    }

    public void actualizarInformacion(String telefono, String telefonoFamiliar){
        appendChange(new InformacionContactoActualizada(telefono, telefonoFamiliar)).apply();
    }
}
