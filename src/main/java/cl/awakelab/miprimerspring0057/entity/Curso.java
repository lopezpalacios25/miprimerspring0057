package cl.awakelab.miprimerspring0057.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10)
    private String nombreCurso;

    @JsonIgnore
    @ManyToMany(mappedBy = "listaCursos")
    private List<Profesor> listaProfesores;

    @JsonIgnore
    @OneToMany(mappedBy = "cursoAsignado")
    private List<Alumno> listaAlumnos;
}
