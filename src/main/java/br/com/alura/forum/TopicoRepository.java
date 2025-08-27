package br.com.alura.forum;

import br.com.alura.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
