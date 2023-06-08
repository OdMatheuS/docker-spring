package br.com.bytewizards.api.repository;

import br.com.bytewizards.api.entity.DoacaoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.channels.FileChannel;

@Repository
public interface DoacaoRepository extends JpaRepository<DoacaoEntity, Long> {
    Page<DoacaoEntity> findAllByAtivoTrue(Pageable paginacao);
}
