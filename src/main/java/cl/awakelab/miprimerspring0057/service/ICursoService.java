package cl.awakelab.miprimerspring0057.service;

import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.entity.Curso;

import java.util.List;

public interface ICursoService {

    public Curso crearCurso(Curso curso);
    public Curso actualizarCurso(Curso curso);

    public List<Curso> listarCursos();
    public Curso listarCursoId(int id);
    public boolean eliminarCurso(int id);
    public boolean eliminarCurso2(Curso curso);
}
