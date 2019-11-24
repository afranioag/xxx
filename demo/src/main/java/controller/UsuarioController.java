package controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajude.ajude.entity.UsuarioEntity;

import serviceImpl.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	public UsuarioController() {
		super();
		this.usuarioService = usuarioService;
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioEntity> cadastrar(@RequestBody UsuarioEntity usuario){
		return ResponseEntity.ok(this.usuarioService.cadastrar(usuario));
	}
	
	@GetMapping("/recuperar/{email}") //requestBody ou path variable?
	public ResponseEntity<Optional<UsuarioEntity>> recuperarUsuarioPorEmail1(@RequestBody String email){
		if(this.usuarioService.recuperarUsuarioPorEmail(email).isPresent()) {
			return ResponseEntity.ok(this.usuarioService.recuperarUsuarioPorEmail(email));
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/perfil") 
	public ResponseEntity<String> perfilUsuario(@RequestBody UsuarioEntity usuario){
		return ResponseEntity.ok(this.usuarioService.perfilUsuario(usuario));
	}
	
}
