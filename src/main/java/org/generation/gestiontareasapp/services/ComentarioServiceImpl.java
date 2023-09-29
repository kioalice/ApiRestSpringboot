package org.generation.gestiontareasapp.services;

import jakarta.transaction.Transactional;
import org.generation.gestiontareasapp.models.Comentario;
import org.generation.gestiontareasapp.repositoy.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ComentarioServiceImpl implements ComentarioService{
    @Autowired
    ComentarioRepository comentarioRepository;

    @Override
    public List<Comentario> listaDeComentarios() {
        return  comentarioRepository.findAll();

    }

    @Override
    public Comentario guardarComentario(Comentario comentarioNuevo) {
        //Se produce el guardado a traves de repositorio
        return comentarioRepository.save(comentarioNuevo);
    }



    @Override
    public void borrarComentario(Long id) {

        comentarioRepository.deleteById(id);
    }

    @Override
    public Comentario editarComentarioPorID(Long id, Comentario comentarioActualizado) {

        boolean existe = comentarioRepository.existsById(id);
        if(existe){
            Comentario comentario = comentarioRepository.findById(id).get();
            comentario.setTexto(comentarioActualizado.getTexto());
            comentario.setFechaCreacion(comentarioActualizado.getFechaCreacion());
            return comentarioRepository.save(comentario);
        }else{
            System.out.println("El Comentario no existe o su id es invalido");
            return null;
        }
    }



}
