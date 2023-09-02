package cl.awakelab.miprimerspring0057.service;

import cl.awakelab.miprimerspring0057.entity.Profesor;

import java.util.List;

public interface IProfesorService {

    public Profesor crearProfesor(Profesor profesor);
    public Profesor actualizarProfesor(Profesor profesor);

    public List<Profesor> listarProfesores();

    public Profesor listarProfesorId(int id);
    public boolean eliminarProfesor(int id);
    public boolean eliminarProfesor2(Profesor profesor);
}
