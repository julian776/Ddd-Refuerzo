package com.sofka.ddd.domain.colaborador;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.ddd.domain.colaborador.events.ColaboradorCreado;
import com.sofka.ddd.domain.colaborador.values.Cedula;
import com.sofka.ddd.domain.colaborador.values.FechaNacimiento;
import com.sofka.ddd.domain.colaborador.values.Genero;
import com.sofka.ddd.domain.colaborador.values.NombreCompleto;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;
import com.sofka.ddd.domain.perfil.Perfil;

import java.util.Objects;

public class Colaborador extends AggregateEvent<HojaDeVidaId> {

    protected FechaNacimiento fechaNacimiento;
    protected NombreCompleto nombreCompleto;
    protected Cedula cedula;
    protected Genero genero;
    protected String area;
    protected Perfil perfil;

    public Colaborador(HojaDeVidaId entityId, FechaNacimiento fechaNacimiento, NombreCompleto nombreCompleto, Cedula cedula, Genero genero, String area, Perfil perfil) {
        super(entityId);
        Objects.requireNonNull(fechaNacimiento);
        Objects.requireNonNull(nombreCompleto);
        Objects.requireNonNull(cedula);
        Objects.requireNonNull(genero);
        Objects.requireNonNull(area);
        Objects.requireNonNull(perfil);
        appendChange(new ColaboradorCreado(fechaNacimiento, nombreCompleto, cedula, genero, area, perfil)).apply();
    }

    private Colaborador(HojaDeVidaId entityId){
        super(entityId);
        subscribe(new ColaboradorChange(this));
    }

    public void modificarNombre(String primerNombre, String segundoNombre){
        appendChange(new NombreCompletoModificado(primerNombre, segundoNombre)).apply();
    }

    public FechaNacimiento getFechaNacimiento() {
        return fechaNacimiento;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getArea() {
        return area;
    }

    public Perfil getPerfil() {
        return perfil;
    }
}
