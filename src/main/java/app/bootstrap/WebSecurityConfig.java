package app.bootstrap;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        	.antMatchers("/login").permitAll()
        	.antMatchers("/admin/**").hasAnyRole("ADMIN")
        	.antMatchers("/app/**").hasAnyRole("ADMIN", "USER")
        	.anyRequest().authenticated()
        .and()
        .formLogin()
         	.loginPage("/login")        	
         		.usernameParameter("email")
         		.passwordParameter("password")
         	.permitAll()
        .and()
        	.logout()
        	.permitAll();
	}
}
