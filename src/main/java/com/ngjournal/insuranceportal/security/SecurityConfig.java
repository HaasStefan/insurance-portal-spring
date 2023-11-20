    package com.ngjournal.insuranceportal.security;

    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.config.Customizer;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
    import org.springframework.security.config.http.SessionCreationPolicy;
    import org.springframework.security.web.SecurityFilterChain;
    import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
    import org.springframework.web.cors.CorsConfiguration;
    import org.springframework.web.cors.CorsConfigurationSource;
    import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
    import org.springframework.web.filter.CorsFilter;

    import java.util.List;

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {

        private final AuthenticationFilter authenticationFilter;

        @Value("${security.allowed_origins}")
        private List<String> allowedOrigins;

        public SecurityConfig(final AuthenticationFilter authenticationFilter) {
            this.authenticationFilter = authenticationFilter;
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            return http
                    .csrf(AbstractHttpConfigurer::disable)
                    .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                    .authorizeHttpRequests(auth -> auth
                            .anyRequest().authenticated()
                    )
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .httpBasic(Customizer.withDefaults())
                    .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    .build();
        }

    //    @Bean
    //    public CorsFilter corsFilter() {
    //        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //        CorsConfiguration config = new CorsConfiguration();
    //        config.setAllowedOrigins(allowedOrigins);
    //        config.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "PATCH"));
    //        source.registerCorsConfiguration("/**", config);
    //        return new CorsFilter(source);
    //    }

        @Bean
        CorsConfigurationSource corsConfigurationSource() {
            System.out.printf("Allowed origins: %s\n", allowedOrigins);
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(allowedOrigins);
            configuration.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "PATCH"));
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);
            return source;
        }

    }