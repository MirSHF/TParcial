package pe.edu.upc.majak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import pe.edu.upc.majak.serviceinterface.IUsuarioService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private IUsuarioService usuarioServicio;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioServicio);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/registro**","/js/**","/css/**","/img/**").permitAll()
			.antMatchers("/distritos").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/ciudades").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/magnitudes").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/bancos").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/epicentros").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/personas").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
			.antMatchers("/tarjetas").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/renovacionsuscripcions").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/eventos").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/notificaciones").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/personaeventos").access("hasRole('ROLE_ADMIN')")
			
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll();
	}
	
}
