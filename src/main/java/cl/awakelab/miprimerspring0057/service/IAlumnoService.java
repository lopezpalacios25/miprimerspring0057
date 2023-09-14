package cl.awakelab.miprimerspring0057.service;

import cl.awakelab.miprimerspring0057.entity.Alumno;

import java.util.List;

public interface IAlumnoService {

    public Alumno crearAlumno(Alumno alumno);
    public Alumno actualizarAlumno(int id, Alumno alumno);
    public Alumno actualizarAlumno(Alumno alumno);
    public List<Alumno> listarAlumno();
    public Alumno listarAlumnoId(int id);
    public boolean eliminarAlumno(int id);
    public boolean eliminarAlumno2(Alumno alumno);

}
