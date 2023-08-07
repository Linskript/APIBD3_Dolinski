package bd0706.bd3.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bd0706.bd3.domain.model.CentroDeCusto;
import bd0706.bd3.domain.model.Usuario;

public interface CentroDeCustoRepository extends JpaRepository<CentroDeCusto, Long>{
 // não preciso implementar nada de diferente nesse caso.
 List<CentroDeCusto> findByUsuario(Usuario usuario);
} 