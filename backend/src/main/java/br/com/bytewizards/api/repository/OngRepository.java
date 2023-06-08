package br.com.bytewizards.api.repository;

import br.com.bytewizards.api.entity.OngEntity;
import br.com.bytewizards.api.entity.dto.ListarOngDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OngRepository extends JpaRepository<OngEntity, Long> {

    Page<OngEntity> findAllByAtivoTrue(Pageable paginacao);
}
