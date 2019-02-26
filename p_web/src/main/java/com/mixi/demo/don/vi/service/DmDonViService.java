package com.mixi.demo.don.vi.service;

import com.mixi.demo.don.vi.DmDonVi;
import com.mixi.demo.don.vi.repository.DmDonViRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DmDonViService {

    @Autowired
    private DmDonViRepository dmDonViRepository;

    public DmDonVi findById(Long id) {
        Optional<DmDonVi> dmDonVi = this.dmDonViRepository.findById(id);

        return dmDonVi.get();
    }
}
