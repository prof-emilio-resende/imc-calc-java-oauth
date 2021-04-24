// package fit.imc.infra.security;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.factory.PasswordEncoderFactories;
// import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// @EnableWebSecurity
// public class BasicSecurityConfiguration extends WebSecurityConfigurerAdapter {
//     @Autowired
//     public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
//         auth.inMemoryAuthentication()
//             .withUser("user")
//             .password("{noop}password")
//             .roles("admin");
//     }
    
//     @Bean
//     public PasswordEncoder getPasswordEncoder() {
//         DelegatingPasswordEncoder encoder = (DelegatingPasswordEncoder)PasswordEncoderFactories.createDelegatingPasswordEncoder();
//         encoder.setDefaultPasswordEncoderForMatches(NoOpPasswordEncoder.getInstance());
//         return encoder;
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//             .httpBasic()
//             .and()    
//             .authorizeRequests()
//             .anyRequest()
//             .authenticated()
//             .and()
//             .logout();
//     }
// }
