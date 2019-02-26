package com.mixi.demo.api;

import com.mixi.demo.don.vi.DmDonVi;
import com.mixi.demo.don.vi.service.DmDonViService;
import com.mixi.demo.infrastructure.NonAccountPrincipal;
import com.mixi.demo.infrastructure.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DmDonViController {

    @Autowired
    private DmDonViService dmDonViService;

    @GetMapping("/hehe/{id}")
    public DmDonVi getData(UserPrincipal userPrincipal, @PathVariable Long id){
        return dmDonViService.findById(id);
    }

    @GetMapping("/haha")
    public void getData(NonAccountPrincipal nonAccountPrincipal){
        System.out.println("Da vao controller");
    }
}
