package org.generation.gestiontareasapp.repositoy;

import org.generation.gestiontareasapp.models.Tareas;
import org.generation.gestiontareasapp.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {



}
