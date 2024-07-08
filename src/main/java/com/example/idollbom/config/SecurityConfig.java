package com.example.idollbom.config;

import com.example.idollbom.service.loginservice.ParentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 웹 보안 활성화 spring security 이용해서
@RequiredArgsConstructor
public class SecurityConfig {

    private final ParentDetailService parentDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//       return http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                new AntPathRequestMatcher("/user/login"),
                                new AntPathRequestMatcher("/user/signup"),
                                new AntPathRequestMatcher("/user/myPage"),
                                new AntPathRequestMatcher("/css/**"),
                                new AntPathRequestMatcher("/js/**"),
                                new AntPathRequestMatcher("/images/**"),
                                new AntPathRequestMatcher("/match"),
                                new AntPathRequestMatcher("/class/**")
                        ).permitAll() // 특정 요청에 대해서는 접근 허용
                        .anyRequest().authenticated() // 나머지 요청들은 인증 필요하게 함
                )

                .formLogin(form -> form
                        .loginPage("/user/login") // 내가 사용할 로그인페이지 요청
                        .usernameParameter("parentEmail") // 스프링 시큐리티에서 username 즉 userid가 pk 역할 짜피 아이디는 무조건 유니크자나
                        .passwordParameter("parentPassword") // 둘다 필드의 이름과 동일하면 상관없음
                        .defaultSuccessUrl("/user/myPage", true) // 로그인 성공 후 리디렉션 경로
                        .successHandler(authenticationSuccessHandler())
                )
                .logout(logout -> logout
                        .logoutUrl("/user/logout")
                        .invalidateHttpSession(true) // 현재 세션 무효화
                        .logoutSuccessUrl("/user/login") // 로그아웃 성공 후 리디렉션 경로
                )
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(parentDetailService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return new ProviderManager(daoAuthenticationProvider);
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (request, response, auth) -> {

//            request.getSession().setAttribute("user", auth.getPrincipal());

            response.sendRedirect("/user/myPage");
        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
