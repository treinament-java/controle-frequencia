package com.senai.backend.controle_frequencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.controle_frequencia.models.Usuario;
import com.senai.backend.controle_frequencia.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
     
    public Long contarUsuarios(){
        return usuarioRepository.count();
    }

    public Usuario buscUsuario(Integer id){
        return usuarioRepository.findById(id).get();
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Boolean deletarUsuario(Integer id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Usuario cadastrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizUsuario(Integer id, Usuario usuario){
        Usuario usuarioRecuperado = buscUsuario(id);
        if(usuarioRecuperado != null){
            usuarioRecuperado.setId(id);
            if(usuario.getNome() !=null){
                usuarioRecuperado.setNome(usuario.getNome());
            }
            if(usuario.getDataNascimento() != null){
                usuarioRecuperado.setDataNascimento(usuario.getDataNascimento());
            }
            return usuarioRepository.save(usuarioRecuperado);
        }
        return null;
    }
}
