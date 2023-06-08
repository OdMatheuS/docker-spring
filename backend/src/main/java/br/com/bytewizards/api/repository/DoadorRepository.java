package br.com.bytewizards.api.repository;

import br.com.bytewizards.api.entity.DoadorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoadorRepository extends JpaRepository<DoadorEntity, Long> {


    Page<DoadorEntity> findAllByAtivoTrue(Pageable paginacao);
}
