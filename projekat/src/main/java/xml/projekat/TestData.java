package xml.projekat;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import xml.projekat.model.User;
import xml.projekat.repository.UserRepository;

@Component
public class TestData {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostConstruct
	private void init(){
		
		// ADMINI
		User user1  = new User("admin@admin.com",bCryptPasswordEncoder.encode("a"), "a","a", "ADMIN", "a", "a");
		userRepo.save(user1);
		
		User user2  = new User("admin2@admin2.com",bCryptPasswordEncoder.encode("a2"), "a2","a2", "ADMIN", "a2", "a2");
		userRepo.save(user2);
		
		// AGENTI
		User user3  = new User("agent@agent.com",bCryptPasswordEncoder.encode("a"), "a","a", "AGENT", "a", "a");
		userRepo.save(user3);
		
		User user4  = new User("agent2@agent2.com",bCryptPasswordEncoder.encode("a2"), "a2","a2", "AGENT", "a2", "a2");
		userRepo.save(user4);
		
		// KORISNICI
		User user5  = new User("a@a.com",bCryptPasswordEncoder.encode("a"), "a","a", "KORISNIK", "a", "a");
		userRepo.save(user5);
		
		User user6  = new User("a2@a2.com",bCryptPasswordEncoder.encode("a2"), "a2","a2", "KORISNIK", "a2", "a2");
		userRepo.save(user6);
	}
}