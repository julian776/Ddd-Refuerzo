package com.sofka.ddd.domain.colaborador.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.colaborador.values.Cedula;
import com.sofka.ddd.domain.colaborador.values.FechaNacimiento;
import com.sofka.ddd.domain.colaborador.values.Genero;
import com.sofka.ddd.domain.colaborador.values.NombreCompleto;
import com.sofka.ddd.domain.perfil.Perfil;

public class ColaboradorCreado extends DomainEvent {
    private FechaNacimiento fechaNacimiento;
    private NombreCompleto nombreCompleto;
    private Cedula cedula;
    private Genero genero;
    private String area;
    private Perfil perfil;

    public ColaboradorCreado(FechaNacimiento fechaNacimiento, NombreCompleto nombreCompleto, Cedula cedula, Genero genero, String area, Perfil perfil) {
        super("sofka.colaborador.colaboradorcreado");
        this.fechaNacimiento = fechaNacimiento;
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.genero = genero;
        this.area = area;
        this.perfil = perfil;
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
