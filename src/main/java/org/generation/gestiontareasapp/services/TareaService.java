package org.generation.gestiontareasapp.services;


import org.generation.gestiontareasapp.models.Tareas;

import java.util.List;

public interface TareaService {

    List<Tareas> listaDeTareas();

    Tareas guardarTarea(Tareas tareaNueva);



    //metodo para borrar segun el id, va a llamar a repository
    void borrarTarea(Long id);

    Tareas editarTareaPorID(Long id, Tareas tareaActualizada);
}
