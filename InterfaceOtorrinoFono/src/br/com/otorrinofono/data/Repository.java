package br.com.otorrinofono.data;

import br.com.otorrinofono.entities.User;

public interface Repository {

	public void insertUser(User user);
	
	public boolean existsUser(String login);
	
}