package ar.edu.unju.fi.service.implement;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.repository.UsuarioRepository;
import ar.edu.unju.fi.testeos.model.Usuario;

@Service
public class LoginUsuarioServiceImp implements UserDetailsService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		
		Usuario usuarioEncontrado = usuarioRepository.findByNombreUsuario(nombreUsuario).orElseThrow(() -> new UsernameNotFoundException("Login Invalido")); 
		
		List<GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipoUsuario().toString());
		tipos.add(grantedAuthority);
		
		UserDetails user = (UserDetails) new User(nombreUsuario,usuarioEncontrado.getPassword(),tipos);
		
		return user;
	}
	
	

}
