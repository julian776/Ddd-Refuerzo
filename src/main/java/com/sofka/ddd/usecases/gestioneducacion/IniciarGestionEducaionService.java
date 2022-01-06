package com.sofka.ddd.usecases.gestioneducacion;

import com.sofka.ddd.domain.experiencia.values.Institucion;
import com.sofka.ddd.domain.gestioneducacion.values.Tipo;

public interface IniciarGestionEducaionService {
    boolean inciarProceso(Institucion institucion, String body);
}
