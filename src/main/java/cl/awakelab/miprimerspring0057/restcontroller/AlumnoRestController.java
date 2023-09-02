package cl.awakelab.miprimerspring0057.restcontroller;

import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoRestController {

    @Autowired
    IAlumnoService objAlumnoService;

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno){
        objAlumnoService.crearAlumno(alumno);
        return alumno;
    }

    @PutMapping("/{id}")
    public Alumno actualizarAlumno(@PathVariable int id, @RequestBody Alumno alumno){
        return  objAlumnoService.actualizarAlumno(id,alumno);

    }

    @GetMapping
    public List<Alumno> listarAlumnos(){
        return objAlumnoService.listarAlumno();
    }

    @GetMapping("/{id}")
    public Alumno listarAlumnoId(@PathVariable int id){

        return objAlumnoService.listarAlumnoId(id);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarAlumno(@PathVariable int id){
        objAlumnoService.eliminarAlumno(id);
        return true;
    }

    @DeleteMapping
    public boolean eliminarAlumno(@RequestBody Alumno alumno){
        objAlumnoService.eliminarAlumno2(alumno);
        return true;
    }
}
