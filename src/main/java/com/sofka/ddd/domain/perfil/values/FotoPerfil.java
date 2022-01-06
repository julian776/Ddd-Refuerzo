package com.sofka.ddd.domain.perfil.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FotoPerfil implements ValueObject<FotoPerfil>{

    private final String rutaArchivo;
    private final String year;

    public FotoPerfil(String rutaArchivo, String year){
        this.rutaArchivo = Objects.requireNonNull(rutaArchivo);
        this.year = Objects.requireNonNull(year);
        if (rutaArchivo.isBlank()){
            throw new IllegalArgumentException("La ruta del archivo no puede estar en blanco");
        }
        if (year.isBlank()){
            throw new IllegalArgumentException("No puede estar en blanco el año");
        }
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public String getYear() {
        return year;
    }

    public FotoPerfil actualizar(String rutaArchivo, String year){
        return new FotoPerfil(rutaArchivo, year);
    }

    @Override
    public FotoPerfil value() {
        return this;
    }
}
