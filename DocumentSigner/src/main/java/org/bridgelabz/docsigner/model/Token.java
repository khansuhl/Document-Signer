package org.bridgelabz.docsigner.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "token")
public class Token {

	@Id
	@GenericGenerator(name = "gene", strategy = "increment")
	@GeneratedValue(generator = "gene")
	@Column(name = "ID")
	private int id;

	@Column(name = "userId")
	private int userId;

	@Column(name = "accessToken")
	private String accessToken;

<<<<<<< HEAD
	@Column(name = "accessTokenValidity")
	private int accessTokenValidity;

	@Column(name = "refreshToken")
	private String refreshToken;

	@Column(name = "refreshTokenValidity")
	private int refreshTokenValidity;

=======
	@Column(name = "refreshToken")
	private String refreshToken;

>>>>>>> 5441ace8e854ce57ebf0dbd119af7651224fc616
	@Column(name = "createdOn")
	private Date createdOn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

<<<<<<< HEAD
	public int getAccessTokenValidity() {
		return accessTokenValidity;
	}

	public void setAccessTokenValidity(int accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public int getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	public void setRefreshTokenValidity(int refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

=======
>>>>>>> 5441ace8e854ce57ebf0dbd119af7651224fc616
}
