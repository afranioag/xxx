package repositorio;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ajude.ajude.entity.CampanhaEntity;

@Repository
public interface CampanhaRepository<T, ID extends Serializable> extends JpaRepository<CampanhaEntity, String>{}
