package xml.projekat.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
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
	private  String userName;
	
	@NotNull
	private String userSurname;
	
	@NotNull
	private String authority;
	
	@NotNull
	private String city;
	
	@NotNull
	private String mobileNumber;
	

	public User() {
		super();
	}


	public User(@NotNull String email, @NotNull String userPassword, @NotNull String userName,
			@NotNull String userSurname, @NotNull String authority, @NotNull String city,
			@NotNull String mobileNumber) {
		super();
		this.email = email;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userSurname = userSurname;
		this.authority = authority;
		this.city = city;
		this.mobileNumber = mobileNumber;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserSurname() {
		return userSurname;
	}


	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
