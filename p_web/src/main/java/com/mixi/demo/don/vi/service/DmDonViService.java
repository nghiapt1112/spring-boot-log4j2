package com.mixi.demo.don.vi.service;

import com.mixi.demo.don.vi.DmDonVi;
import com.mixi.demo.don.vi.DonViException;
import com.mixi.demo.don.vi.repository.DmDonViRepository;
import com.mixi.demo.infrastructure.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DmDonViService extends AbstractService {

    @Autowired
    private DmDonViRepository dmDonViRepository;

    public DmDonVi findById(Long id) {

        Optional<DmDonVi> dmDonVi = this.dmDonViRepository.findById(id);
        if (!dmDonVi.isPresent()) {
            throw new DonViException(toStr("error.donVi.code"), toStr("error.donVi.msg"));
        }
        return dmDonVi.get();
    }
}
