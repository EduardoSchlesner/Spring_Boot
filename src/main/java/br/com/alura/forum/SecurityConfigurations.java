package br.com.alura.forum;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    //configurações de autenticação!!!
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    }

    //Configurações de Autorização!!!
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/").permitAll()
                .antMatchers(HttpMethod.GET,"/topicos/*").permitAll(); //liberando acesso aos endpoints publicos


    }

    //Configuracoes de recursos estáticos (requisições de javascript, css, imagens, etc...)
    @Override
    public void configure(WebSecurity web) throws Exception {
    }
}
