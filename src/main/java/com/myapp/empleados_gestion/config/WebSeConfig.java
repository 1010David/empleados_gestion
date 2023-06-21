package com.myapp.empleados_gestion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class WebSeConfig implements WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;
    @Autowired
    private BCryptPasswordEncoder passEncoder;
    @Autowired
    public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passEncoder)
                .usersByUsernameQuery("SELECT nombre, password, activo FROM user WHERE nombre=?")
                .authoritiesByUsernameQuery("SELECT u.nombre, r.rol FROM roles r INNER JOIN user u ON r.user_id=u.id WHERE u.nombre=?");

    }

    /**
     * @param builder
     * @throws Exception
     */
    @Override
    public void init(SecurityBuilder builder) throws Exception {

    }

    /**
     * @param builder
     * @throws Exception
     */
    @Override
    public void configure(SecurityBuilder builder) throws Exception {

    }
}



