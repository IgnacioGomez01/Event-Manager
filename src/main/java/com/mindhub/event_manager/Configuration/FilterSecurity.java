package com.mindhub.event_manager.Configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@EnableWebSecurity
@Configuration
public class FilterSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(path -> {
                    path.requestMatchers("/index.html", "/v3/api-docs/**", "/swagger-ui/**").permitAll()
                            .requestMatchers(HttpMethod.POST, "/api/crearevento").hasAnyAuthority("ADMIN", "MANAGER")
                            .requestMatchers("/api/events").hasAuthority("USER")
                            .anyRequest().permitAll();
                })
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .cors(Customizer.withDefaults()) // Habilitar CORS
                .headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(
                        frameOptionsConfig -> frameOptionsConfig.disable()))
                .formLogin(formLogin -> {
                    formLogin.loginPage("/index.html")
                            .loginProcessingUrl("/api/login")
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .permitAll()
                            .successHandler((request, response, authentication) -> clearAuthenticationAttributes(request))
                            .failureHandler((request, response, exception) -> response.sendError(401, "Invalid user or password"));
                })
                .logout(httpSecurityLogoutConfigurer ->
                        httpSecurityLogoutConfigurer
                                .logoutUrl("/api/logout")
                                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                                .deleteCookies("JSESSIONID"))
                .rememberMe(Customizer.withDefaults());
        return http.build();
    }

    // Configuración global de CORS
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true); // Permitir envío de credenciales (si es necesario)
        config.addAllowedOrigin("http://127.0.0.1:5500"); // Permitir el origen del frontend
        config.addAllowedHeader("*"); // Permitir todos los encabezados
        config.addAllowedMethod("*"); // Permitir todos los métodos HTTP (GET, POST, etc.)

        source.registerCorsConfiguration("/api/**", config); // Aplicar CORS a las rutas /api/**
        return new CorsFilter(source);
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }
    }
}
