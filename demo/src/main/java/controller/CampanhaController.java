package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajude.ajude.entity.CampanhaEntity;

import serviceImpl.CampanhaService;

@RestController
@RequestMapping("/api/campanhas")
public class CampanhaController {
	@Autowired
	private CampanhaService campanhaService;
	
	public CampanhaController() {
		super();
		this.campanhaService = campanhaService;
	}
	
	@PostMapping("/api/cadastrarcampanha")
	public ResponseEntity<CampanhaEntity> cadastrarCampanha(@RequestBody CampanhaEntity campanha){
		return ResponseEntity.ok(this.campanhaService.cadastrarCampanha(campanha));
	}
	
	@GetMapping("/api/campanhas/{subString}")
	public ResponseEntity<List<CampanhaEntity>> listarCampanhas(@PathVariable ("subString") String subString){
		return new ResponseEntity<List<CampanhaEntity>>(campanhaService.pesquisaCampanha(subString), HttpStatus.OK);
	}	
	
//	@PutMapping("/like")
//	public ResponseEntity<Boolean> like(){
//		this.campanhaService.like();
//		return new ResponseEntity<Boolean>(HttpStatus.OK);
//	}	
//	
//	@PutMapping("/retiraLike")
//	public ResponseEntity<Boolean> retiraLike(){
//		this.campanhaService.retiraLike();
//		return new ResponseEntity<Boolean>(HttpStatus.OK);
//	}
}