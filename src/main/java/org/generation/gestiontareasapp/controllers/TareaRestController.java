package org.generation.gestiontareasapp.controllers;

import org.generation.gestiontareasapp.models.Tareas;
import org.generation.gestiontareasapp.models.Usuario;
import org.generation.gestiontareasapp.services.TareaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaRestController {
    @Autowired
    TareaServiceImpl tareaService;

    //cotrolador que se va a encargar de guardar
    @PostMapping("/nuevo")
    public Tareas guardarNuevaTarea(@RequestBody Tareas tareaNueva){
        Tareas tareaGuardar = tareaService.guardarTarea(tareaNueva);
        return tareaGuardar;
    }

    @GetMapping(value = "/listar")
    public List<Tareas> listaTareas(){
        List<Tareas> listaMostrar = tareaService.listaDeTareas();

        return listaMostrar;
    }



    @DeleteMapping ("/borrar{id}")
    public String borrarTarea(@RequestParam Long id) {
        tareaService.borrarTarea(id);
        return "La tarea fue borrada";
    }



    @PutMapping("/editar/{id}")
    public Tareas editarTarea(@RequestBody Tareas tareaActualizada,@PathVariable Long id){

        Tareas tareaEditada = tareaService.editarTareaPorID(id,tareaActualizada);
        return tareaEditada;
    }

    @GetMapping(value = "/listadetareas")
    public ModelAndView mostrarLista(){
        List<Tareas> listaMostrartarea = tareaService.listaDeTareas();
        return new ModelAndView("listaMostrartarea").addObject(listaMostrartarea);

    }





}
