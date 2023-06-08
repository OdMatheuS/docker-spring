package br.com.bytewizards.api.repository;

import br.com.bytewizards.api.entity.DistribuicaoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.channels.FileChannel;

@Repository
public interface DistribuicaoRepository extends JpaRepository<DistribuicaoEntity, Long> {


    Page<DistribuicaoEntity> findAllByAtivoTrue(Pageable paginacao);
}
