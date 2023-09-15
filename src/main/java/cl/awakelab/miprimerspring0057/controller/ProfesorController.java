package cl.awakelab.miprimerspring0057.controller;

import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.entity.Profesor;
import cl.awakelab.miprimerspring0057.service.ICursoService;
import cl.awakelab.miprimerspring0057.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("profesor")
public class ProfesorController {

    @Autowired
    IProfesorService objProfesorService;

    @Autowired
    ICursoService objCursoService;

    @GetMapping("/listar")
    public String listarProfesores(Model model){
        List<Profesor> listaProfesores = objProfesorService.listarProfesores();
        model.addAttribute("listaProfesores",listaProfesores);
        model.addAttribute("titulo", "Gestión de Profesores");
        return "templateProfesores";
    }

    @GetMapping("/crearProfesor")
    public String formCrearProfesor(Model model){
        List<Curso> listaCursos = objCursoService.listarCursos();
        model.addAttribute("listaCursos", listaCursos);
        model.addAttribute("titulo", "Creación de Profesor");
        return "templateCrearProfesor";
    }

    @PostMapping("/crearProfesor")
    public String crearProfesor(@ModelAttribute Profesor profesor){
        objProfesorService.crearProfesor(profesor);
        return "redirect:/profesor/listar";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizarProfesorForm(Model model, @PathVariable Integer id){
        Profesor profesor = objProfesorService.listarProfesorId(id);
        List<Curso> listaCursos = objCursoService.listarCursos();
        model.addAttribute("listaCursos", listaCursos);
        model.addAttribute("profesor",profesor);
        model.addAttribute("titulo", "Edición de Profesor");
        return "templateActualizarProfesor";
    }

    @PostMapping("/actualizar")
    public String actualizarProfesor(@ModelAttribute Profesor profesor){
        objProfesorService.actualizarProfesor(profesor);
        return "redirect:/profesor/listar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarProfesor(@PathVariable Integer id){
        objProfesorService.eliminarProfesor(id);
        return "redirect:/profesor/listar";
    }
}
