package org.generation.gestiontareasapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuario")
@NoArgsConstructor //constructor vacio
@AllArgsConstructor // constructor con todos los atributos
@Getter
@Setter
public class Usuario {
    @Id //Le indicamos que es la llave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;
    @NotNull
    private String nombre_usuario;
    @Email(message = "Introdujiste un email erroneo")
    @NotNull
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Tareas> usuariotareas;



}
