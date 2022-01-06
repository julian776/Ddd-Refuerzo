package com.sofka.ddd.domain.perfil;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.ddd.domain.perfil.events.InformacionContactoActualizada;

public class PerfilChange extends EventChange {
    public PerfilChange(Perfil perfil) {
        apply((InformacionContactoActualizada event) -> {
            perfil.informacionContacto = perfil.informacionContacto
                    .actualizar(event.getTelefono(), event.getTelefonoFamiliar());
        });
    }
}
