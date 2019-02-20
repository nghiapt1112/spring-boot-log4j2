package com.example.log4j2demo.mixi;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DmDonViRepository extends SimpleJpaRepository<DmDonVi, Long> {

//    @PersistenceContext
    private EntityManager em;

    public DmDonViRepository(EntityManager entityManager) {
        super(DmDonVi.class, entityManager);
        this.em = entityManager;
    }



}
