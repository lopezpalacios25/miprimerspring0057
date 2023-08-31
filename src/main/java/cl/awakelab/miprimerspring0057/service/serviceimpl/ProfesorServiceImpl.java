package cl.awakelab.miprimerspring0057.service.serviceimpl;

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

        return null;
    }

    @Override
    public List<Profesor> listarProfesores() {
        List<Profesor> listaProfesores = new ArrayList<>();
        listaProfesores = objProfesorRepo.findAll();
        return listaProfesores;
    }

    @Override
    public boolean eliminarProfesor(int id) {

        return false;
    }
}
