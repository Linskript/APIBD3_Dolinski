package bd0706.bd3.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bd0706.bd3.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}