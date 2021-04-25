package fit.imc.infra.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(3)
public class OauthSecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/v2/imc/**")
            .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
            .and()
                .httpBasic()
                .disable()
                .oauth2ResourceServer()
                .jwt();
    }

}
