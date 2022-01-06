package com.sofka.ddd.domain.hojavida;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.ddd.domain.hojavida.events.HojaDeVidaCreada;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;

public class HojaDeVida extends AggregateEvent<HojaDeVidaId> {

    public HojaDeVida(HojaDeVidaId hojaDeVidaId){
        super(hojaDeVidaId);
        appendChange(new HojaDeVidaCreada()).apply();
        subscribe(new HojaDeVidaChange(this));
    }
}
