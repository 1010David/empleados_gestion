package com.myapp.empleados_gestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Autowired
    BCryptPasswordEncoder passEncoder;
    public void configurerSecurityGlobal(AuthenticationManagerBuilder builder)throws Exception{
        try {
            builder
                    .jdbcAuthentication()
                    .passwordEncoder(passEncoder)
                    .passwordEncoder(passEncoder)
                    .usersByUsernameQuery("SELECT nombre, password, activo FROM user WHERE nombre=?")
                    .authoritiesByUsernameQuery("SELECT u.nombre, r.rol FROM roles r INNER JOIN user u ON r.user_id=u.id WHERE u.nombre=?");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
