/**
 * Andre Santoro, Gustavo Pedro Lima, Maisa Moreira
 *
 * 01/10/2022
 *
 * Esse programa foi feito para fins educativos, para a materia
 * de Programacaoo Orientada a Objetos, oferecida no Centro
 * Universitário IESB no periodo 2022.2, ministrada pelo professor
 * Kenniston Arraes.
 */
package com.napi.security;

import com.napi.user.UserDetailsServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Classe que configura as permissoes dos protocolos HTTP
 */
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImplementation userService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /* gerenciador de autenticacoes */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }

    /* configura as permissoes dos protocolos http */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login")
                .permitAll()
                .antMatchers(HttpMethod.POST,"/usuarios/adicionar")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new SecurityAuthenticationFilter(authenticationManager()))
                .addFilter(new SecurityAuthorizationFilter(authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}