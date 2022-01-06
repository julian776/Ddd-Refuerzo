package com.sofka.ddd.domain.hojavida;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.ddd.domain.hojavida.events.HojaDeVidaCreada;

public class HojaDeVidaChange extends EventChange {
    public HojaDeVidaChange(HojaDeVida hojaDeVida) {
        apply((HojaDeVidaCreada event) ->{
        });
    }
}
