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
import java.util.List;

@Entity
@Table(name = "tareas")
@NoArgsConstructor //constructor vacio
@AllArgsConstructor // constructor con todos los atributos
@Getter
@Setter
public class Tareas {
    @Id //Le indicamos que es la llave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tareaId;
    @Column(name = "titulo")
    @NotNull
    private String titulo;
    @Column(name = "descripcionTarea")
    @NotNull
    private String descripcionTarea;
    @NotNull
    @DateTimeFormat(pattern = "YYYY-MM-DD") // Define el formato esperado de la fecha
    private Date fechaVencimiento;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
   @JsonIgnore
    @OneToMany(mappedBy = "tareas", cascade = CascadeType.ALL)
    private List<Comentario> comentario;








}
