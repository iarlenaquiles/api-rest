package br.com.restful.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.restful.controller.UsuarioController;
import br.com.restful.model.Usuario;

@Path("/usuario")
public class UsuarioResource {

	UsuarioController user = new UsuarioController();

	private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@GET
	@Path("/get/{id}")
	@Produces("application/json")
	public String listar(@PathParam("id") int id) {
		Usuario usuario = new UsuarioController().get(id);
		String json = gson.toJson(usuario);
		return json;
	}

	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public String listarTodos() {
		ArrayList<Usuario> usuarios = new UsuarioController().listarTodos();
		String json = gson.toJson(usuarios);
		return json;
	}


	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/inserir")
	public Usuario addUsuario(String usuario) {
		Usuario json = gson.fromJson(usuario, Usuario.class);
		return user.addUsuario(json);
	}

}
