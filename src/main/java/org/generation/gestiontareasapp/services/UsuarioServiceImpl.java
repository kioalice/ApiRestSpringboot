package org.generation.gestiontareasapp.services;

import jakarta.transaction.Transactional;
import org.generation.gestiontareasapp.models.Tareas;
import org.generation.gestiontareasapp.models.Usuario;
import org.generation.gestiontareasapp.repositoy.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listaDeUsuario() {
        return  usuarioRepository.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuarioNuevo) {

        //Se produce el guardado a traves de repositorio
        return usuarioRepository.save(usuarioNuevo);

    }



    @Override
    public void borrarUsuario(Long id) {
        usuarioRepository.deleteById(id);

    }

    @Override
    public Usuario editarUsuarioPorID(Long id, Usuario usuarioActualizado) {
        boolean existe = usuarioRepository.existsById(id);
        if(existe){
            Usuario usuario = usuarioRepository.findById(id).get();
            usuario.setNombre_usuario(usuarioActualizado.getNombre_usuario());
            usuario.setEmail(usuarioActualizado.getEmail());
            return usuarioRepository.save(usuario);
        }else{
            System.out.println("El estudiante no existe o su id es invalido");
            return null;
        }
    }


}
