package br.com.herbertrausch.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import br.com.herbertrausch.util.SpringUtil;

public class UsuarioService {

	
	private UsuarioRepository db;
	
	public UsuarioService(){
		
		ApplicationContext context=SpringUtil.getContext();
		db = context.getBean(UsuarioRepository.class);
		
	}

	// Lista todos os usuarios do banco de dados
	public List<Usuario> getUsuarios() {
		try {
			
			List<Usuario> usuarios = (List<Usuario>) db.findAll();
					
			return usuarios;
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Usuario>();

		}
	}
	
	public List<Usuario> getByIdUsuario(String a){
		return db.findByIdUsuario(a);
	}
	
	public List<Usuario> getByNome(String a){
		return db.findByNome(a);
	}
	
	public Usuario getByLogin(String a){
		return (Usuario) db.findByLogin(a);
	}
	
	public Usuario getBySenha(String a){
		return (Usuario) db.findBySenha(a);
	}
	
	public Usuario getByEmail(String a){
		return (Usuario) db.findByEmail(a);
	}

	public Usuario getUsuario(Long id) {
		try {
			
			
			return db.findOne(id);
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	// Deleta o carro pelo id
	public boolean delete(Long id) {
		try {
			db.delete(id);
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Salva ou atualiza o carro
	public boolean save(Usuario usuario) {
		try {
			
				db.save(usuario);
			
			return true;
		}  catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}



}