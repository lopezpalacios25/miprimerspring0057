package cl.awakelab.miprimerspring0057.restcontroller;

import cl.awakelab.miprimerspring0057.entity.Usuario;
import cl.awakelab.miprimerspring0057.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {

    @Autowired
    IUsuarioService objUsuarioService;

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){

        objUsuarioService.crearUsuario(usuario);
        return usuario;

    }

    @GetMapping
    public List<Usuario> listarUsuarios(){

        return objUsuarioService.listarUsuario();
    }

    @GetMapping("/{id}")
    public Usuario listarUsuarioId(@PathVariable int id) {
        return objUsuarioService.listarUsuarioId(id);
    }
}
