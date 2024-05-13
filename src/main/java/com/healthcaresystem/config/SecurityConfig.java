package com.healthcaresystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Autowired
    private DataSource dataSource;


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        String usersByUsernameQuery = "select email, password, true as enabled from users where email = ?";
        String authsByUserQuery = "SELECT u.email, r.name FROM users u JOIN role r ON u.roleid = r.rid where email = ?";

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        userDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
        userDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);
        return userDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth->auth.requestMatchers("/img/","/css/").permitAll());

        http.authorizeHttpRequests(configure -> configure
                        .requestMatchers("/resources/**").authenticated()
                        .requestMatchers("/user_panel_navbar").permitAll()
                        .requestMatchers("/doctor/**").hasAuthority("DOCTOR")
                        .requestMatchers("/calender").hasAuthority("DOCTOR")
                        .requestMatchers("/static/**").permitAll()
                        .requestMatchers("/api/events").hasAuthority("DOCTOR")
                        .requestMatchers("/doctor/getCalender").hasAuthority("DOCTOR")
                          .requestMatchers("/admin/**").hasAuthority("ADMIN")
                          .requestMatchers("/patient").hasAuthority("PATIENT")


//                        .requestMatchers("/").hasRole("student")
//                        .requestMatchers("/list/").hasRole("president")
//                        .requestMatchers("/system/").hasRole("admin")
                        .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login")
                        .loginProcessingUrl("/secProcessUser")
                        .defaultSuccessUrl("/secProcessUser")

                         .permitAll())
                .logout( form ->form
                .logoutUrl("/logout") // Oturum kapatma URL'si
                .logoutSuccessUrl("/login?logout") // Başarılı oturum kapatma sonrası yönlendirilecek URL
                .permitAll());;
//                .exceptionHandling(handler -> handler.accessDeniedPage("/access-denied"));
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();}


        @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authManager(UserDetailsService detailsService){
        DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
        daoProvider.setUserDetailsService(detailsService);
        daoProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(daoProvider);
    }}



//    @Autowired
//    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
//       authenticationManagerBuilder.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
//
//    }

//    @Bean
//    public AuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider =
//                new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder());
//        provider.setUserDetailsService(this.userDetailService);
//        return provider;
//    }

