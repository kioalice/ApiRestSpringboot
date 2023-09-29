package org.generation.gestiontareasapp.services;

import org.generation.gestiontareasapp.models.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listaDeUsuario();

    Usuario guardarUsuario(Usuario usuarioNuevo);



    //metodo para borrar segun el id, va a llamar a repository
    void borrarUsuario(Long id);

    Usuario editarUsuarioPorID(Long id, Usuario usuarioActualizado);
}
