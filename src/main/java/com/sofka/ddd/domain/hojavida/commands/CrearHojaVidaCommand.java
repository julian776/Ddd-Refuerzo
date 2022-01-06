package com.sofka.ddd.domain.hojavida.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;

public class CrearHojaVidaCommand extends Command {

    private final HojaDeVidaId hojaDeVidaId;

    public CrearHojaVidaCommand(HojaDeVidaId hojaDeVidaId){

        this.hojaDeVidaId = hojaDeVidaId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
