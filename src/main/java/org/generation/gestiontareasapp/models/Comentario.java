package org.generation.gestiontareasapp.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "comentario")
@NoArgsConstructor //constructor vacio
@AllArgsConstructor // constructor con todos los atributos
@Getter
@Setter
public class Comentario {
    @Id //Le indicamos que es la llave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentarioId;
    @Column(name = "texto")
    @NotNull
    private String texto;
    @NotNull
    @DateTimeFormat(pattern = "YYYY-MM-DD") // Define el formato esperado de la fecha
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "tarea_id", nullable = false)
    private Tareas tareas;


}
