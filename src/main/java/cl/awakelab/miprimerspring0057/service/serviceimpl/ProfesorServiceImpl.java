package cl.awakelab.miprimerspring0057.service.serviceimpl;

import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.entity.Profesor;
import cl.awakelab.miprimerspring0057.repository.IProfesorRepository;
import cl.awakelab.miprimerspring0057.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("profesoServiceImpl")
public class ProfesorServiceImpl implements IProfesorService {

    @Autowired
    IProfesorRepository objProfesorRepo;
    @Override
    public Profesor crearProfesor(Profesor profesorCreado) {
        Profesor nuevoProfesor;
        nuevoProfesor = objProfesorRepo.save(profesorCreado);
        return nuevoProfesor;
    }

    @Override
    public Profesor actualizarProfesor(Profesor profesor) {
        Profesor profesorEncontrado = objProfesorRepo.findById(profesor.getId()).orElse(null);
        profesorEncontrado.setNombres(profesor.getNombres());
        profesorEncontrado.setApellido1(profesor.getApellido1());
        profesorEncontrado.setApellido2(profesor.getApellido2());
        profesorEncontrado.setListaCursos(profesor.getListaCursos());
        objProfesorRepo.save(profesorEncontrado);

        return profesorEncontrado;
    }

    @Override
    public List<Profesor> listarProfesores() {
        List<Profesor> listaProfesores = new ArrayList<>();
        listaProfesores = objProfesorRepo.findAll();
        return listaProfesores;
    }

    @Override
    public Profesor listarProfesorId(int id) {
        return objProfesorRepo.findById(id).orElse(null);
    }

    @Override
    public boolean eliminarProfesor(int id) {
        objProfesorRepo.deleteById(id);
        return false;
    }

    @Override
    public boolean eliminarProfesor2(Profesor profesor) {

        objProfesorRepo.delete(profesor);
        return true;
    }
}
