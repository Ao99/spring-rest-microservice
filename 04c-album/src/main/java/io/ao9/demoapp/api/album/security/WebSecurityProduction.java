package io.ao9.demoapp.api.album.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Profile("production")
public class WebSecurityProduction extends WebSecurityConfigurerAdapter {

    private Environment env;

    @Autowired
    public WebSecurityProduction(Environment env) {
        this.env = env;
    }
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().hasIpAddress(env.getProperty("gateway.ip"));
                
        http.headers().frameOptions().disable();
        http.csrf().disable();
    }
    
}