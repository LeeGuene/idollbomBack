package com.example.idollbom.config;

import com.example.idollbom.domain.dto.logindto.CustomUserDTO;
import com.example.idollbom.domain.dto.logindto.ParentDTO;
import com.example.idollbom.domain.dto.prodto.ProDetailDTO;
import com.example.idollbom.mapper.loginmapper.ParentMapper;
import com.example.idollbom.mapper.proMapper.ProDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final ParentMapper parentMapper;
    private final ProDetailMapper proDetailMapper;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                new AntPathRequestMatcher("/user/login"),
                                new AntPathRequestMatcher("/user/signup"),
                                new AntPathRequestMatcher("/user/myPage"),
                                new AntPathRequestMatcher("/user/proSignup"),
                                new AntPathRequestMatcher("/css/**"),
                                new AntPathRequestMatcher("/images/**"),
                                new AntPathRequestMatcher("/js/**"),
                                new AntPathRequestMatcher("/match/**"),
                                new AntPathRequestMatcher("/class/**"),
                                new AntPathRequestMatcher("/parentmain/**"),
                                new AntPathRequestMatcher("/promain/**"),
                                new AntPathRequestMatcher("/parentcommunity/**"),
                                new AntPathRequestMatcher("/ask/**"),
                                new AntPathRequestMatcher("/rest/**"),
                                new AntPathRequestMatcher("/restList/**")
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/user/login")
                        .usernameParameter("parentEmail")
                        .passwordParameter("parentPassword")
//                        .defaultSuccessUrl("/user/myPage", true)
                        .successHandler(authenticationSuccessHandler())
                )
                .logout(logout -> logout
                        .logoutUrl("/user/logout")
                        .invalidateHttpSession(true)
                        .logoutSuccessUrl("/user/login")
                )
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return email -> {
            ParentDTO parentDTO = parentMapper.selectOneDTO(email);
            ProDetailDTO proDetailDTO = proDetailMapper.selectOneDTO(email);
            System.out.println(parentDTO);

            if (parentDTO != null) {
                System.out.println("부모");
                return new CustomUserDTO(parentDTO.getParentEmail(), parentDTO.getParentPassword(), parentDTO.getRole());
            }
            else{
                System.out.println("프로");
                return new CustomUserDTO(proDetailDTO.getProEmail(), proDetailDTO.getProPassword(), proDetailDTO.getRole());
            }
        };
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return new ProviderManager(daoAuthenticationProvider());
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (request, response, authentication) -> {
            System.out.println("들어옴");
            CustomUserDTO userDTO = (CustomUserDTO) authentication.getPrincipal();

            if(userDTO.getRole().equals("parent")){
                response.sendRedirect("/parentmain");
            }
            else{
                response.sendRedirect("/promain");
            }

        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

// pro insert 회원가입 부분
// 회원가입 하면서 쿼리문 마지막에 role 에 pro 추가