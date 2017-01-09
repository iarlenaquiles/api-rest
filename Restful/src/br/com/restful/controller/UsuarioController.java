package br.com.restful.controller;

import java.util.ArrayList;
import br.com.restful.dao.UsuarioDAO;
import br.com.restful.model.Usuario;

public class UsuarioController {
	
	public Usuario get(int id){
		return UsuarioDAO.getInstance().listar(id);
	}
	
	public ArrayList<Usuario> listarTodos(){
		return UsuarioDAO.getInstance().listarTodos();
	}

	
	public Usuario addUsuario(Usuario usuario) {
		return UsuarioDAO.getInstance().salvar(usuario);
	}
	

}
