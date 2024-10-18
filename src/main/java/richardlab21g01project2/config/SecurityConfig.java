package richardlab21g01project2.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import richardlab21g01project2.auth.AuthenticationSuccessHandler;
import richardlab21g01project2.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private UserService userService;

    @Bean
    public UserService userDetailsService() {
        return userService;
    }

    // @Bean
    // public InMemoryUserDetailsManager userDetailsService() {
    //     UserDetails user = User.withUsername("user")
    //         .password(passwordEncoder().encode("user"))
    //         .roles("USER")
    //         .build();
    //     UserDetails admin = User.withUsername("admin")
    //         .password(passwordEncoder().encode("adminPass"))
    //         .roles("ADMIN")
    //         .build();
    //     return new InMemoryUserDetailsManager(user, admin);
    // }

    @Bean 
    public PasswordEncoder passwordEncoder() { 
        return new BCryptPasswordEncoder(); 
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return (request, response, exception) -> {
            response.sendRedirect("/login?error=true");
        };
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return (request, response, authentication) -> {
            response.sendRedirect("/login?logout=true");
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/home", "/register/**").permitAll();
                    registry.requestMatchers("/admin/**").hasRole("ADMIN");
                    registry.requestMatchers("/user/**").hasRole("USER");
                    registry.anyRequest().permitAll();
                })
                .formLogin(httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer
                        .loginPage("/login")
                        .loginProcessingUrl("/api/login")
                        .successHandler(new AuthenticationSuccessHandler())
                        .permitAll();
                })
                .logout(logoutConfigurer -> {
                    logoutConfigurer
                        .logoutUrl("/api/logout")
                        .logoutSuccessHandler(logoutSuccessHandler())
                        .permitAll();
                })
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
}