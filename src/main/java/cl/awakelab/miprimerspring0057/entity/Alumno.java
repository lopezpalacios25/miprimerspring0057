package cl.awakelab.miprimerspring0057.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombres;

    @Column
    private String apellido1;

    @Column
    private String apellido2;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_Curso", nullable = false)
    private Curso cursoAsignado;
}
