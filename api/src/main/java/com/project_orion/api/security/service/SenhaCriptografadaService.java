package com.project_orion.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SenhaCriptografadaService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String get(String senhaAberta) {
        return passwordEncoder.encode(senhaAberta);
    }

}
