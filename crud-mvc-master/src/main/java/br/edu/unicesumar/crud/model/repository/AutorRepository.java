package br.edu.unicesumar.crud.model.repository;

import br.edu.unicesumar.crud.model.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
