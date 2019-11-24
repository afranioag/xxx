package serviceImpl;

import java.text.Normalizer;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajude.ajude.entity.CampanhaEntity;

import repositorio.CampanhaRepository;

@Service
public class CampanhaService{

	@Autowired
	private CampanhaRepository campanhaRepository;
	@Autowired
	private CampanhaEntity campanha;
	
	public String concertaUrl(CampanhaEntity campanha) throws PatternSyntaxException{
		String str = "";
		
		str = Normalizer.normalize(campanha.getNomeCurto(), Normalizer.Form.NFD).replaceAll("^\\p{ASCII}*$", "");
	    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	    str = pattern.matcher(str).replaceAll("");
	    str = pattern.matcher(str).replaceAll("").replaceAll("\\p{Punct}", "").
	    		replaceAll("( )+", " ").replaceAll(" ", "-").toLowerCase();
		
		return str;
	}
	
	public CampanhaEntity cadastrarCampanha(CampanhaEntity campanha) {
		return (CampanhaEntity) this.campanhaRepository.save(campanha);
	}
	
	public CampanhaEntity listarCampanhas() {
		return (CampanhaEntity) this.campanhaRepository.findAll();
	}
	
	/**
	 * O metodo recebe uma substring como paramentro e faz uma busca dentro do 
	 * repositorio onde se encontra as campanhas salvas, vai recupenrando uma a uma
	 * e fazendo a verificação usando String.indexOf(subString), caso a parte informada 
	 * não pertença ao nome curto da campanha será retornado -1 e caso exista será retornado
	 * a posição onde se encontra q será maior que 1. 
	 * Cada campanha encontrada contendo a subString será armazenada em uma lista que sera retornada ao final
	 *  
	 * @param subString string passada para pesquisa
	 * @return retorna uma lista contendo nenhuma, uma ou mais campanhas encontradas.
	 */
	public List<CampanhaEntity> pesquisaCampanha(String subString){
		List<CampanhaEntity> campanhas = campanhaRepository.findAll();
		List<CampanhaEntity> campanhasSalvas = new LinkedList<CampanhaEntity>();
		
		for(CampanhaEntity c: campanhas) {
			if(c.getNomeCurto().indexOf(subString) > 0) {
				campanhasSalvas.add(c);
			}
		}
		
		return campanhasSalvas;
	}
	
	public void alteraStatus(int id, String novoStatus) {
		((CampanhaEntity) campanhaRepository.findAll().get(id)).setStatus(novoStatus);
	}
	
//	@Override
//	public void like() {
//		this.campanha.setLike(true);
//	}
//	
//	@Override
//	public void retiraLike() {
//		if(this.campanha.getLike() == true) {
//			campanha.setLike(false);
//		}
//	}
}
