package xml.projekat.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private long userId;
	
	@NotNull
	private String email;
	
	@NotNull
	private String userPassword;
	
	@NotNull
	private String userPasswordConf;
	
	@NotNull
	private  String userName;
	
	@NotNull
	private String userSurname;
	
	@NotNull
	private String city;
	
	@NotNull
	private String mobileNumber;
	
	@NotNull
	private UserRole userRole;
	

	public User() {
		super();
	}

	public User(String email, String userPassword, String userPasswordConf,String userName,
			String userSurname,String city, String mobileNumber, UserRole userRole) {
		super();
		this.email = email;
		this.userPassword = userPassword;
		this.userPasswordConf = userPasswordConf;
		this.userName = userName;
		this.userSurname = userSurname;
		this.city = city;
		this.mobileNumber = mobileNumber;
		this.userRole = userRole;
		
	}
	
	
	
}
