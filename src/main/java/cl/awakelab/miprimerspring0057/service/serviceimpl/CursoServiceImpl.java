package cl.awakelab.miprimerspring0057.service.serviceimpl;

import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.repository.ICursoRepository;
import cl.awakelab.miprimerspring0057.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cursoServiceImpl")
public class CursoServiceImpl implements ICursoService {

    @Autowired
    ICursoRepository objCursoRepo;
    @Override
    public Curso crearCurso(Curso curso) {

        return objCursoRepo.save(curso);
    }

    @Override
    public Curso actualizarCurso(Curso curso) {
        return null;
    }

    @Override
    public List<Curso> listarCursos() {
        return objCursoRepo.findAll();
    }

    @Override
    public Curso listarCursoId(int id) {
        return objCursoRepo.findById(id).orElse(null);
    }

    @Override
    public boolean eliminarCurso(int id) {
        objCursoRepo.deleteById(id);
        return true;
    }
    @Override
    public boolean eliminarCurso2(Curso curso) {
        objCursoRepo.delete(curso);
        return true;
    }
}
