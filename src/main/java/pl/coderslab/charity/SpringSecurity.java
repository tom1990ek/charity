package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import pl.coderslab.charity.services.SpringDataUserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .anyRequest().permitAll()
                .and().formLogin().loginPage("/login")
                .passwordParameter("password")
                .usernameParameter("email")
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and().exceptionHandling().accessDeniedPage("/403")
        ;
    }
    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {

        return new SpringDataUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Autowired
//    AuthenticationSuccessHandler successHandler;
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}password").roles("ADMIN");
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
////                .antMatchers("/user").hasAnyRole("USER")
////                .antMatchers("/admin").hasAnyRole("ADMIN")
//                .and().formLogin().loginPage("/login")
//                .successHandler(successHandler)
//                .permitAll()
//
//                .and().logout();
//    }
}
