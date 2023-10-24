package br.edu.unicesumar.crud.model.repository;

import br.edu.unicesumar.crud.model.domain.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora,Long> {
}
