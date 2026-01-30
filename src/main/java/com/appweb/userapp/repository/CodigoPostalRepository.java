package com.appweb.userapp.repository;

import com.appweb.userapp.model.CodigoPostal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodigoPostalRepository extends JpaRepository<CodigoPostal,Long> {
}
