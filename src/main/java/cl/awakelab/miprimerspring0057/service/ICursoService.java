package cl.awakelab.miprimerspring0057.service;

import cl.awakelab.miprimerspring0057.entity.Curso;

import java.util.List;

public interface ICursoService {

    public Curso crearCurso(Curso curso);
    public Curso actualizarCurso(Curso curso);

    public List<Curso> listarCursos();
    public boolean eliminarCurso(int id);
}
