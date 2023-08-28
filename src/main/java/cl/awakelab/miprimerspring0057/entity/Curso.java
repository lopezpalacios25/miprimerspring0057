package cl.awakelab.miprimerspring0057.entity;

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

    @Column(length = 1)
    private String nombreCurso;

    @ManyToMany(mappedBy = "listaCursos")
    private List<Profesor> listaProfesores;

    @OneToMany(mappedBy = "cursoAsignado")
    private List<Alumno> listaAlumnos;
}
