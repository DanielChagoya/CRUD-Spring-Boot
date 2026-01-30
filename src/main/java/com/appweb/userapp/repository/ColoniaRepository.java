package com.appweb.userapp.repository;

import com.appweb.userapp.model.Colonia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColoniaRepository extends JpaRepository<Colonia, Long> {
}
