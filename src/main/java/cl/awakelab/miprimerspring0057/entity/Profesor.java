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
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column
    private String nombres;

    @Column
    private String apellido1;

    @Column
    private String apellido2;

    @ManyToMany
    @JoinTable(name = "curso_profesor",
            joinColumns = @JoinColumn(name = "FK_Profesor",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_Curso", nullable = false))
    private List<Curso> listaCursos;

    @Override
    public String toString() {
        return "Profesor[id=" + id + ", nombres=" + nombres + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + "]";
    }


}
