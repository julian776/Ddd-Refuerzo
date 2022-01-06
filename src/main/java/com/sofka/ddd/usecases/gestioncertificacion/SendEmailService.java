package com.sofka.ddd.usecases.gestioncertificacion;

import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;

public interface SendEmailService {
    boolean send(String email, String body, HojaDeVidaId hojaDeVidaId);
}
