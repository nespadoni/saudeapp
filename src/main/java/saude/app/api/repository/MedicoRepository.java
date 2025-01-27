package saude.app.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import saude.app.api.model.Medico;

import java.util.List;

// 1 é qual tipo a ‘interface’ irá trabalhar
// 2 é, qual tipo da chave primaria - no caso Long por conta do ‘Id’
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findByAtivoTrue(Pageable paginacao);
    Page<Medico> findByAtivoFalse(Pageable paginacao);
}
