
package com.team4.fitness_and_wellbeing;

import com.team4.fitness_and_wellbeing.filters.JwtRequestFilter;
import com.team4.fitness_and_wellbeing.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtrequestfilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()


                .mvcMatchers("/html/**", "/images/**", "/css/**", "/js/**", "/font/**","/favicon.ico","/img/**","/ExerciseImg/**").permitAll()
                .mvcMatchers("/authenticate", "/register", "/home", "/login", "/console","/createRoutine", "/comment","/showcomments","/addComment","/countdown",
                        "/getClientList","/search","/uploadFile","/deleteFile",
                        "/multipleImageUpload","/imageUpload",
                        "/uploadImg","/uploadImgAjax","/uploadImgDuo",
                        "/doExercise", "/goExercise",
                        "/details","/DetailsInfo","/updateInfo","/addDetails",
                        "/showDetails","/completeDetails","/viewComment").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtrequestfilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new CustomUserDetailService();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeRequests()
//                .mvcMatchers("/css/**").permitAll()
//                .mvcMatchers("/images/**").permitAll()
//                .mvcMatchers("/js/**").permitAll()
//                .mvcMatchers("/static/**").permitAll()
//                .mvcMatchers("/").permitAll()
//                .mvcMatchers("/html/**").permitAll()
//                .mvcMatchers("/public/**").permitAll()
//                //.mvcMatchers("/admin/**").authenticated()
//                //.mvcMatchers("/trainer/**").hasRole("Trainer")
//                .anyRequest().anonymous()
//                .and()
//                .formLogin();
//    }


/*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, HttpSecurity http) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("Admin");


        auth
                .inMemoryAuthentication()
                .withUser("zheliu").password("{noop}zheliu").roles("User-Client");
        http
                .authorizeRequests()
//                .mvcMatchers("/css/**").permitAll()
//                .mvcMatchers("/static/css/**").permitAll()
//                .mvcMatchers("/").permitAll()
//                .mvcMatchers("/html/**").permitAll()
//                .mvcMatchers("/public/**").permitAll()
//                .mvcMatchers("public/console").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .usernameParameter("email")
                .defaultSuccessUrl("/public/console.html")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/").permitAll();
//                .mvcMatchers("/trainer/**").hasRole("Trainer")
//                .and()
//                .formLogin();
    }*/

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//
//    }

    //    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("Admin");
//
//
//        auth
//                .inMemoryAuthentication()
//                .withUser("zheliu").password("{noop}zheliu").roles("User-Client");
//    }
}
