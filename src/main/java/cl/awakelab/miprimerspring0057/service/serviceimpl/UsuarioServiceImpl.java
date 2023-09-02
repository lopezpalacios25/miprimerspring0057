package cl.awakelab.miprimerspring0057.service.serviceimpl;

import cl.awakelab.miprimerspring0057.entity.Usuario;
import cl.awakelab.miprimerspring0057.repository.IUsuarioRepository;
import cl.awakelab.miprimerspring0057.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository objUsuarioRepo;
    @Override
    public Usuario crearUsuario(Usuario usuario) {

        return objUsuarioRepo.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario usuarioActualizado = new Usuario();
        usuarioActualizado = objUsuarioRepo.findById(usuario.getId()).orElse(null);
        usuarioActualizado.setNombre(usuario.getNombre());
        usuarioActualizado.setRol(usuario.getRol());
        usuarioActualizado.setPassword(usuario.getPassword());
        objUsuarioRepo.save(usuarioActualizado);
        return usuarioActualizado;
    }

    @Override
    public List<Usuario> listarUsuario() {
        return objUsuarioRepo.findAll();
    }

    @Override
    public Usuario listarUsuarioId(int id) {

        return objUsuarioRepo.findById(id).orElse(null);
    }

    @Override
    public boolean eliminarUsuario(int id) {

        objUsuarioRepo.deleteById(id);
        return true;
    }

    @Override
    public boolean eliminarUsuario2(Usuario usuario) {
        objUsuarioRepo.delete(usuario);
        return true;
    }
}
