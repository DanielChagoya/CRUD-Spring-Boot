package com.appweb.userapp.repository;

import com.appweb.userapp.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    List<Estado> findByPais_IdPais(Long idPais);
}
