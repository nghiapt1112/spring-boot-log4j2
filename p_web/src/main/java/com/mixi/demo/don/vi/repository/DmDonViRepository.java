package com.mixi.demo.don.vi.repository;

import com.mixi.demo.don.vi.DmDonVi;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class DmDonViRepository extends SimpleJpaRepository<DmDonVi, Long> {

//    @PersistenceContext
    private EntityManager em;

    public DmDonViRepository(EntityManager entityManager) {
        super(DmDonVi.class, entityManager);
        this.em = entityManager;
//        em.createNamedStoredProcedureQuery()
    }

}
