package cl.awakelab.miprimerspring0057.restcontroller;

import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.entity.Usuario;
import cl.awakelab.miprimerspring0057.service.ICursoService;
import cl.awakelab.miprimerspring0057.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoRestController {

    @Autowired
    ICursoService objCursoService;

    @PostMapping
    public Curso crearCurso(@RequestBody Curso curso){

        objCursoService.crearCurso(curso);
        return curso;

    }

    @PutMapping
    public Curso actualizarCurso(@RequestBody Curso curso){
        return  objCursoService.actualizarCurso(curso);
    }

    @GetMapping
    public List<Curso> listarCursos(){

        return objCursoService.listarCursos();
    }

    @GetMapping("/{id}")
    public Curso listarCursoId(@PathVariable int id) {

        return objCursoService.listarCursoId(id);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarCurso(@PathVariable int id){
        objCursoService.eliminarCurso(id);
        return true;
    }

    @DeleteMapping
    public boolean eliminarCurso2(@RequestBody Curso curso){
        objCursoService.eliminarCurso2(curso);
        return true;
    }
}
