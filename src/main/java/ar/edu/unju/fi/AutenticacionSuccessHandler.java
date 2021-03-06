package ar.edu.unju.fi;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


/**
 * @author maximiliano
 * Esta clase maneja el exito del logueo, redirigiendo a distintas paginas dependiendo el usuario
 */

@Component
public class AutenticacionSuccessHandler implements AuthenticationSuccessHandler{
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		boolean tipoRegistrador=false;
		boolean tipoConsultor=false;
		boolean tipoBD=false;
		
		Collection<? extends GrantedAuthority >authorities = authentication.getAuthorities();
		for(GrantedAuthority grantedAuthority : authorities) {
			if(grantedAuthority.getAuthority().equals("REGISTRADOR")) {
				tipoRegistrador=true;
				break;
			}
			else {
				if(grantedAuthority.getAuthority().equals("CONSULTOR")) {
					tipoConsultor=true;
					break;
				}
				else {
					tipoBD=true;
					break;
				}
			}
		}
		if(tipoRegistrador) {
			redirectStrategy.sendRedirect(request, response,"/registroTesteo");
		}
		else {
			if(tipoConsultor) {
				redirectStrategy.sendRedirect(request, response,"/consulta");
			}
			else {
				if(tipoBD) {
					redirectStrategy.sendRedirect(request, response,"/usuario");
				}
				else {
					throw new IllegalStateException();
				}
			}
		}
	}

}
