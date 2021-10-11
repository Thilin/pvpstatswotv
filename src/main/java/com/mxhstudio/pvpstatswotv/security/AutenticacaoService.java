package com.mxhstudio.pvpstatswotv.security;

import com.mxhstudio.pvpstatswotv.exceptions.ObjectNotFoundException;
import com.mxhstudio.pvpstatswotv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(email).orElseThrow(()-> new ObjectNotFoundException("Email não encontrado"));
        return user;
    }
}
