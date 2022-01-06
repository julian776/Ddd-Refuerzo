package com.sofka.ddd.domain.perfil.events;

import co.com.sofka.domain.generic.DomainEvent;

public class InformacionContactoActualizada extends DomainEvent{
    public InformacionContactoActualizada() {
        super("sofka.perfil.informacionactualizada");
    }
}
