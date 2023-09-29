package org.generation.gestiontareasapp.controllers;

import org.generation.gestiontareasapp.models.Comentario;
import org.generation.gestiontareasapp.models.Tareas;
import org.generation.gestiontareasapp.services.ComentarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/Comentario")
public class ComentarioRestController {
    @Autowired
    ComentarioServiceImpl comentarioService;

    @PostMapping("/nuevo")
    public Comentario guardarNuevoComentario(@RequestBody Comentario comentarioNuevo){
        Comentario comentarioGuardar = comentarioService.guardarComentario(comentarioNuevo);
        return comentarioGuardar;
    }
    @GetMapping(value = "/lista")
    public List<Comentario> listaComentario(){
        List<Comentario> listaComentario = comentarioService.listaDeComentarios();
        return listaComentario;
    }


    @DeleteMapping ("/borrar")
    public String borrarComentario(@RequestParam Long id) {
        comentarioService.borrarComentario(id);
        return "El Comentario fue borrado";
    }

    @PutMapping("/editar/{id}")
    public Comentario editarComentario(@RequestBody Comentario comentarioActualizado,@PathVariable Long id){

        Comentario comentarioEditado = comentarioService.editarComentarioPorID(id,comentarioActualizado);
        return comentarioEditado;
    }
    @GetMapping(value = "/listadeComentarios/")
    public ModelAndView mostrarLista(){
        List<Comentario> listaMostrar = comentarioService.listaDeComentarios();
        return new ModelAndView("listaMostrarcomentario").addObject(listaMostrar);

    }





}
