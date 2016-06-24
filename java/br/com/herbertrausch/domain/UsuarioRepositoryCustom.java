package br.com.herbertrausch.domain;

import java.util.List;

public interface UsuarioRepositoryCustom {
	
	Usuario findByNome(String nome);
	Usuario findByLogin(String login);
	List<Usuario> findByEmail(String email);

}
