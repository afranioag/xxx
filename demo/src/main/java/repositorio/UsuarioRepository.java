package repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ajude.ajude.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository<T, ID extends Serializable> extends JpaRepository<UsuarioEntity, String>{}
