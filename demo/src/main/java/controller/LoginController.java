package controller;

import java.sql.Date;
import java.util.Optional;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajude.ajude.entity.UsuarioEntity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import serviceImpl.UsuarioService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	private final String TOKEN_KEY = "login do aluno";

	private UsuarioService aluno;

	public LoginController(UsuarioService aluno) {
		super();
		this.aluno = aluno;
	}

	@PostMapping()
	public LoginResponse authenticate(@RequestBody UsuarioEntity alunoEntity) throws ServletException {

		Optional<UsuarioEntity> authAluno = aluno.recuperarUsuarioPorEmail(alunoEntity.getEmail());

		if (!authAluno.isPresent()) {
			throw new ServletException("Usuario nao encontrado!");
		}

		if (!authAluno.get().getSenha().equals(alunoEntity.getSenha())) {
			throw new ServletException("Senha invalida!");
		}

		String token = Jwts.builder().setSubject(authAluno.get().getEmail()).signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
				.setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000)).compact();

		return new LoginResponse(token);

	}

	private class LoginResponse {
		public String token;

		public LoginResponse(String token) {
			this.token = token;
		}
	}
}
