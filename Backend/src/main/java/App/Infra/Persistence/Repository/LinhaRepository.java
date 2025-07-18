package App.Infra.Persistence.Repository;

import App.Domain.Response.Linha;
import App.Infra.Persistence.Entity.LinhaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Repository
public interface LinhaRepository extends JpaRepository<LinhaEntity,Long> {

    Optional<LinhaEntity> findByidentificador(String identificador);
}
