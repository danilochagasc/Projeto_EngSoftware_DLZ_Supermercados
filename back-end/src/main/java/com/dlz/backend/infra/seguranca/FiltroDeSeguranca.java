package com.dlz.backend.infra.seguranca;

import com.dlz.backend.repository.ClienteRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class FiltroDeSeguranca extends OncePerRequestFilter {


    final TokenService tokenService;
    final ClienteRepository clienteRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var token = receberToken(request);

        if(token != null){

            var email = TokenService.validarToken(token);

            UserDetails cliente = clienteRepository.findByEmail(email);

            var autenticacao = new UsernamePasswordAuthenticationToken(cliente, null, cliente.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(autenticacao);
        }

        filterChain.doFilter(request, response);
    }

    private String receberToken(HttpServletRequest request){

        var header = request.getHeader("Authorization");

        if(header == null) return null;

        return header.replace("Bearer ", "");
    }
}
