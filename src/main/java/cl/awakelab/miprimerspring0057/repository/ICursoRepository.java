package cl.awakelab.miprimerspring0057.repository;

import cl.awakelab.miprimerspring0057.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Integer> {
}
