package org.generation.gestiontareasapp.services;

import org.generation.gestiontareasapp.models.Comentario;

import java.util.List;

public interface ComentarioService {


    List<Comentario> listaDeComentarios();

    Comentario guardarComentario(Comentario comentarioNuevo);



    //metodo para borrar segun el id, va a llamar a repository
    void borrarComentario(Long id);

    Comentario editarComentarioPorID(Long id, Comentario comentarioActualizado);


}
