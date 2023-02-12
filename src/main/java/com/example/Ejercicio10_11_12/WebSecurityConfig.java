package com.example.Ejercicio10_11_12;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/laptop").permitAll() // Nos permite modificar las URL'S
                .requestMatchers("api/laptops").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin(); // enable form based log in(habilitar inicio de sesión basado en formulario)
        return http.build();
    }

    // Firewall
//    @Bean
//    public HttpFirewall loosehttpFirewall(){
//        StrictHttpFirewall firewall = new StrictHttpFirewall();
//        // Aquí vamos a cambiar la configuración.
//        firewall.setAllowBackSlash(true);
//        firewall.setAllowSemicolon(true);
//
//        return  firewall;
//
//    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("Nathalia Vanessa Perdomo Ortiz")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("Sergio Andres Perdomo Ortiz")
                .password(passwordEncoder().encode("password")) // para encriptar la contraseña.
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
