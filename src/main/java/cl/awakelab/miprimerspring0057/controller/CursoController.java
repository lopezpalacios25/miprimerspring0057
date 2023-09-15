package cl.awakelab.miprimerspring0057.controller;

import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.entity.Profesor;
import cl.awakelab.miprimerspring0057.service.IAlumnoService;
import cl.awakelab.miprimerspring0057.service.ICursoService;
import cl.awakelab.miprimerspring0057.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private ICursoService objCursoService;

    @Autowired
    private IProfesorService objProfesorService;

    @Autowired
    private IAlumnoService objAlumnoService;

    @GetMapping("listar")
    public String listarCursos(Model model){
        List<Curso> listaCursos = objCursoService.listarCursos();
        model.addAttribute("listaCursos",listaCursos);
        model.addAttribute("titulo", "Gestión de Cursos");
        return "templateCursos";
    }

    @GetMapping("/crearCurso")
    public String crearCurso(Model model){
        model.addAttribute("titulo", "Creación de Cursos");
        return "templateCrearCurso";
    }

    @PostMapping("/crearCurso")
    public String crearCurso(@ModelAttribute Curso curso){

        objCursoService.crearCurso(curso);
        return "redirect:/curso/listar";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizarCursoForm(Model model, @PathVariable Integer id){
        Curso curso = objCursoService.listarCursoId(id);
        model.addAttribute("curso",curso);
        model.addAttribute("titulo", "Edición de Curso");
        return "templateActualizarCurso";
    }

    @PostMapping("/actualizar")
    public String actualizarCurso(@ModelAttribute Curso curso){
        objCursoService.actualizarCurso(curso);
        return "redirect:/curso/listar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable Integer id){
        objCursoService.eliminarCurso(id);
        return "redirect:/curso/listar";
    }

}
