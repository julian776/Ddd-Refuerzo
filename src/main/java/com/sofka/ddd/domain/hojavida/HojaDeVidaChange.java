package com.sofka.ddd.domain.hojavida;

import co.com.sofka.domain.generic.EventChange;

public class HojaDeVidaChange extends EventChange {
    public HojaDeVidaChange(HojaDeVida hojaDeVida) {
        apply((HojaDeVidaCreada event) ->{
        });
    }
}
