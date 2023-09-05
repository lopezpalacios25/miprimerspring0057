package cl.awakelab.miprimerspring0057.service.serviceimpl;

import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.repository.IAlumnoRepository;
import cl.awakelab.miprimerspring0057.repository.ICursoRepository;
import cl.awakelab.miprimerspring0057.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("alumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    IAlumnoRepository objAlumnoRepo;

    @Autowired
    ICursoRepository objCursoRepo;
    @Override
    public Alumno crearAlumno(Alumno alumno) {
        Curso cursoAsignado = new Curso();
        cursoAsignado = objCursoRepo.findById(alumno.getCursoAsignado().getId()).orElse(null);
        alumno.setCursoAsignado(cursoAsignado);
        objAlumnoRepo.save(alumno);
        return alumno;
    }

    @Override
    public Alumno actualizarAlumno(int id, Alumno alumnoActualizar) {
        Alumno alumnoEncontrado = objAlumnoRepo.findById(id).orElse(null);
        alumnoEncontrado.setNombres(alumnoActualizar.getNombres());
        alumnoEncontrado.setApellido1(alumnoActualizar.getApellido1());
        alumnoEncontrado.setApellido2(alumnoActualizar.getApellido2());
        alumnoEncontrado.setCursoAsignado(alumnoActualizar.getCursoAsignado());
        objAlumnoRepo.save(alumnoEncontrado);
        return alumnoEncontrado;
    }

    @Override
    public List<Alumno> listarAlumno() {

        return objAlumnoRepo.findAll();
    }

    @Override
    public Alumno listarAlumnoId(int id) {

        return objAlumnoRepo.findById(id).orElse(null);
    }

    @Override
    public boolean eliminarAlumno(int id) {
        try{
            objAlumnoRepo.deleteById(id);
            return true;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean eliminarAlumno2(Alumno alumno) {
        try{
            objAlumnoRepo.delete(alumno);
            return true;

        }catch (Exception e){
            return false;
        }
    }
}
