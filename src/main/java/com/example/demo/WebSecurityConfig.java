/*
package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
*/
/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //
		.anyRequest().authenticated() //
		.and() //
		.httpBasic() //
		.and() // Damit die Session auf dem Server bzw. in Cookie nicht gespeichert werden
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // mit STATELESS wird keine Session gespeicher, auch wenn der Benutzer eine mit sich bringt.

	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() { // somit erstellt man mithilfe vom Bean ein Benutzerverzeichnis
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder(); // damit das Passwort entcodeirt wird
		UserDetails user = User.withUsername("user").password(encoder.encode("password")).roles("USER").build();
		return new InMemoryUserDetailsManager(user);
	}

	*//*


}
*/
