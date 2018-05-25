package xml.projekat.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select email, user_password, true"
            + " from user where email=?")
        .authoritiesByUsernameQuery("select email, authority "
            + "from user where email=?").passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
        .authorizeRequests()
        	.antMatchers("/", "/*.html").permitAll()
        	.antMatchers("/login").permitAll()
        	.antMatchers("/register").permitAll()
        	.antMatchers("/user/registerUser").permitAll()
        	.antMatchers("/user/status").permitAll()
        	.antMatchers("/user/korisnik").hasAuthority("KORISNIK")
        	.antMatchers("/user/admin").hasAuthority("ADMIN")
        	.antMatchers("/user/agent").hasAuthority("AGENT")
        	.anyRequest()
        	.authenticated().and().csrf().disable().formLogin().loginPage("/login").defaultSuccessUrl("/index.html").failureUrl("/login?error=true")
			.and().logout().logoutUrl("/logout").clearAuthentication(true)
	        .deleteCookies("JSESSIONID")
	        .invalidateHttpSession(true);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

}