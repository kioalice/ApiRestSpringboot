package org.generation.gestiontareasapp.services;

import jakarta.transaction.Transactional;
import org.generation.gestiontareasapp.models.Tareas;
import org.generation.gestiontareasapp.models.Usuario;
import org.generation.gestiontareasapp.repositoy.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TareaServiceImpl implements TareaService{
    @Autowired
    TareaRepository tareaRepository;
    @Override
    public List<Tareas> listaDeTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public Tareas guardarTarea(Tareas tareaNueva) {
        return tareaRepository.save(tareaNueva);
    }



    @Override
    public void borrarTarea(Long id) {
        boolean existe = tareaRepository.existsById(id);
        if (existe){
            tareaRepository.deleteById(id);
        }else{
            System.out.println("Tarea no existe");

        }


    }

    @Override
    public Tareas editarTareaPorID(Long id, Tareas tareaActualizada) {
        boolean existe = tareaRepository.existsById(id);
        if(existe){
            Tareas tareas = tareaRepository.findById(id).get();
            tareas.setTitulo(tareaActualizada.getTitulo());
            tareas.setDescripcionTarea(tareaActualizada.getDescripcionTarea());
            tareas.setFechaVencimiento(tareaActualizada.getFechaVencimiento());
            return tareaRepository.save(tareas);
        }else{
            System.out.println("El Curso no existe o su id es invalido");
            return null;
        }
    }




}
