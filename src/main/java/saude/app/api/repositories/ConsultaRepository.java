package saude.app.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import saude.app.api.models.Consulta;

import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Page<Consulta> findByAtivoTrue(Pageable paginacao);

    Page<Consulta> findByAtivoFalse(Pageable paginacao);

    Page<Consulta> findByDataHora(String dataHora, Pageable paginacao);
}
