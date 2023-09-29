package org.generation.gestiontareasapp.controllers;

import org.generation.gestiontareasapp.models.Tareas;
import org.generation.gestiontareasapp.models.Usuario;
import org.generation.gestiontareasapp.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Permite indicar la ruta base para los estudiantes
@RequestMapping("/usuario")
public class UsuarioRestController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    //cotrolador que se va a encargar de guardar
    @PostMapping("/nuevo")
    public Usuario guardarNuevoUsuario(@RequestBody Usuario usuarioNuevo){
        Usuario usuarioGuardar = usuarioService.guardarUsuario(usuarioNuevo);
        return usuarioGuardar;
    }

    @GetMapping(value = "/listar")
    public List<Usuario> listaUsuario(){
        List<Usuario> listaMostrar = usuarioService.listaDeUsuario();

        return listaMostrar;
    }


    @DeleteMapping ("/borrar")
    public String borrarUsuario(@RequestParam Long id) {
        usuarioService.borrarUsuario(id);
        return "El usuario fue borrado";
    }

    @PutMapping("/editar/{id}")
    public Usuario editarUsuario(@RequestBody Usuario usuarioActualizado,@PathVariable Long id){

        Usuario usuarioEditado = usuarioService.editarUsuarioPorID(id,usuarioActualizado);
        return usuarioEditado;
    }




}
