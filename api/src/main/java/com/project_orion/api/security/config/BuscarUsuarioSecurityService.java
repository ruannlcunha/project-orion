package com.project_orion.api.security.config;

import com.project_orion.api.domain.Usuario;
import com.project_orion.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioSecurityService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return usuarioRepository.findByEmail(email)
                .map((Usuario usuario) -> new UsuarioSecurity(usuario))
                .orElseThrow(() -> new UsernameNotFoundException("Credenciais inválidas"));
    }
}
