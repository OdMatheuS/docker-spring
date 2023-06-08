package br.com.bytewizards.api.repository;

import br.com.bytewizards.api.entity.AlimentoEntity;
import br.com.bytewizards.api.entity.dto.ListarAlimentoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.channels.FileChannel;

@Repository
public interface AlimentoRepository extends JpaRepository<AlimentoEntity, Long> {


    Page<AlimentoEntity> findAllByAtivoTrue(Pageable paginacao);
}
