package serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajude.ajude.entity.CampanhaEntity;
import com.ajude.ajude.entity.UsuarioEntity;

import repositorio.UsuarioRepository;

@Service 
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	private CampanhaEntity campanha;
	
	public UsuarioEntity cadastrar(UsuarioEntity usuario) {
//		if (usuario.equals(null)) 
//			throw new IllegalArgumentException("Usuario nao pode ser null");
		
		return (UsuarioEntity) this.usuarioRepository.save(usuario);
	}
	
	public Optional<UsuarioEntity> recuperarUsuarioPorEmail(String email) {
		Optional user = this.usuarioRepository.findById(email);
		
//		if(user.equals(null)) {
//			throw new IllegalArgumentException("Usuario nao existe");
//		}
		
		return user;
	}

	public String perfilUsuario(UsuarioEntity usuario) { //retorna pefil do usuario
		String str;
		
		if (usuarioRepository.existsById(usuario.getEmail())) { //se o usuario existir no repositorio
			str = usuario.getPrimeroNome() + usuario.getUltimoNome() + usuario.getEmail() + ". Campanhas: [" + 
					campanhasUsuario(usuario) + "]";
		} else {
			throw new IllegalArgumentException("Usuario nao encontrado");
		}
		return str;
	}
	
	private String campanhasUsuario(UsuarioEntity usuario) { //lista as campanhas do usuario
		String str = "";
		for(int i = 0; i <= usuario.getCampanhas().size(); i++) {
			campanha = (CampanhaEntity) usuario.getCampanhas().get(i);
			str += campanha.getNomeCurto() + " ";
		}
		str = str.substring(0, str.length()-1);
		return str;	
	}
}
