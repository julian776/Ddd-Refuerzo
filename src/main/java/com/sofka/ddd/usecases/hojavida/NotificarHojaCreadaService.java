package com.sofka.ddd.usecases.hojavida;

import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;

public interface NotificarHojaCreadaService {
    String notificar(HojaDeVidaId hojaDeVidaId, String body);
}
