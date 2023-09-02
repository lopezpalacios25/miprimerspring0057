package cl.awakelab.miprimerspring0057.service;

import cl.awakelab.miprimerspring0057.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    public Usuario crearUsuario(Usuario usuario);
    public Usuario actualizarUsuario(Usuario usuario);
    public List<Usuario> listarUsuario();

    public Usuario listarUsuarioId(int id);
    public boolean eliminarUsuario(int id);
    public boolean eliminarUsuario2(Usuario usuario);
}
