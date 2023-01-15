package com.oop.napi.domain.security;

import com.oop.napi.domain.services.UserDetailsServiceImpl;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class JWTConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl usuarioService;
    private final PasswordEncoder passwordEncoder;

    public JWTConfig(UserDetailsServiceImpl usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.POST, "/usuarios/adicionar").permitAll()
                .antMatchers("/**/swagger-ui.html").permitAll()
                .antMatchers(HttpMethod.GET, "/**/webjars/springfox-swagger-ui/**", "/**/v2/api-docs/**", "/**/swagger-resources/**").permitAll()
                .antMatchers(HttpMethod.POST, "/usuarios/esqueci-senha").permitAll()
                .antMatchers(HttpMethod.POST, "/usuarios/resetar-senha").permitAll()
                .antMatchers(HttpMethod.GET, "/personagem/listar").permitAll()
                .antMatchers(HttpMethod.GET, "/personagem/listar/{id}").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}