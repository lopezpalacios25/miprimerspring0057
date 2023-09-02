package cl.awakelab.miprimerspring0057.restcontroller;

import cl.awakelab.miprimerspring0057.entity.Alumno;
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

    @PutMapping
    public Usuario actualizarUsuario(@RequestBody Usuario usuario){
        return  objUsuarioService.actualizarUsuario(usuario);

    }

    @GetMapping
    public List<Usuario> listarUsuarios(){

        return objUsuarioService.listarUsuario();
    }

    @GetMapping("/{id}")
    public Usuario listarUsuarioId(@PathVariable int id) {

        return objUsuarioService.listarUsuarioId(id);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarUsuario(@PathVariable int id){
        objUsuarioService.eliminarUsuario(id);
        return true;
    }

    @DeleteMapping
    public boolean eliminarUsuario2(@RequestBody Usuario usuario){
        objUsuarioService.eliminarUsuario2(usuario);
        return true;
    }
}
