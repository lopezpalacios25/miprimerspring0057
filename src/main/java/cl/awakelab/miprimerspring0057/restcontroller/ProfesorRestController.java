package cl.awakelab.miprimerspring0057.restcontroller;

import cl.awakelab.miprimerspring0057.entity.Profesor;
import cl.awakelab.miprimerspring0057.entity.Usuario;
import cl.awakelab.miprimerspring0057.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorRestController {

    @Autowired
    IProfesorService objProfesorService;

    @PostMapping
    public Profesor crearProfesor(@RequestBody Profesor profesor){
        return objProfesorService.crearProfesor(profesor);
    }

    @PutMapping
    public Profesor actualizarProfesor(@RequestBody Profesor profesor){
        return objProfesorService.actualizarProfesor(profesor);

    }

    @GetMapping
    public List<Profesor> listarProfesores(){
        return objProfesorService.listarProfesores();
    }

    @GetMapping("/{id}")
    public Profesor listarProfesorId(@PathVariable int id){
        return objProfesorService.listarProfesorId(id);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarProfesor(@PathVariable int id){
        objProfesorService.eliminarProfesor(id);
        return true;
    }

    @DeleteMapping
    public boolean eliminarCurso2(@RequestBody Profesor profesor){
        objProfesorService.eliminarProfesor2(profesor);
        return true;
    }
}
