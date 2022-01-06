package com.sofka.ddd.domain.hojavida;

import co.com.sofka.domain.generic.AggregateEvent;

public class HojaDeVida extends AggregateEvent<HojaDeVidaId> {

    public HojaDeVida(HojaDeVidaId hojaDeVidaId){
        super(hojaDeVidaId);
        appendChange(new HojaDeVidaCreada()).apply();
    }

    private HojaDeVida(HojaDeVidaId hojaDeVidaId){
        super(hojaDeVidaId);
        subscribe(new HojaDeVidaChange(this));
    }
}
