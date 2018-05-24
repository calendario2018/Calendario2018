package util;

import entity.User;

public class InfoUser {
	
	private User usuario;
	
	public InfoUser(User pUsuario) {
		usuario=pUsuario;
	}
	public User getUsuario() {
		return usuario;
	}
	public void setUsuario(User pUser) {
		usuario=pUser;
	}

}
