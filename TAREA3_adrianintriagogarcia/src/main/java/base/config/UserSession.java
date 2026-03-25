package base.config;

import org.springframework.stereotype.Component;

import base.model.Credencial;

@Component
public class UserSession {
		private Credencial usuarioLogueado;
		
		public void login (Credencial c){ this.usuarioLogueado = c;}
		public void logout() { this.usuarioLogueado = null;}
		
		public  Credencial getUusarioLogueado() { return usuarioLogueado;}
		
		public boolean isLogged() { return usuarioLogueado !=null;}
}
