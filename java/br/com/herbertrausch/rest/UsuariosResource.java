package br.com.herbertrausch.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.herbertrausch.domain.Usuario;
import br.com.herbertrausch.domain.UsuarioService;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class UsuariosResource {
	
	public UsuarioService usuarioService = new UsuarioService();
	

	@GET
	public List<Usuario> get() {
		List<Usuario> usuarios = usuarioService.getUsuarios();
		return usuarios;
	}

	@GET
	@Path("{idUsuario}")
	public Usuario get(@PathParam("idUsuario") long idUsuario) {
		Usuario c = usuarioService.getUsuario(idUsuario);
		return c;
	}

	@GET
	@Path("/nome/{nome}")
	public List<Usuario> getByNome(@PathParam("nome") String nome) {
		List<Usuario> usuarios = usuarioService.getByNome(nome);
		return usuarios;
	}
	
	@GET
	@Path("/login/{login}")
	public Usuario getByLogin(@PathParam("login") String login) {
		Usuario usuarios = usuarioService.getByLogin(login);
		return usuarios;
	}
	
	@GET
	@Path("/senha/{senha}")
	public Usuario getBySenha(@PathParam("senha") String senha) {
		Usuario usuarios = usuarioService.getBySenha(senha);
		return usuarios;
	}
	
	@GET
	@Path("/email/{email}")
	public Usuario getByEmail(@PathParam("email") String email) {
		Usuario usuarios = usuarioService.getByEmail(email);
		return usuarios;
	}
	
	@DELETE
	@Path("{idUsuario}")
	public String delete(@PathParam("idUsuario") long idUsuario) {
		usuarioService.delete(idUsuario);
		return ("Usuario deletado com sucesso");
	}

	@POST
	public String post(Usuario c) {
		usuarioService.save(c);
		return ("Usuario salvo com sucesso");
	}

	@PUT
	public String put(Usuario c) {
		usuarioService.save(c);
		return ("Usuario atualizado com sucesso");
	}

}