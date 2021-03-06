package com.madpoints.webscraper.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="wallet")
	private String wallet = "10000";
	
	@ManyToMany(fetch=FetchType.LAZY,
			   cascade={CascadeType.PERSIST, CascadeType.MERGE,
						CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name="user_stock",
	   joinColumns=@JoinColumn(name="user_id"),
	   inverseJoinColumns=@JoinColumn(name="stock_id"))
	private List<Stock> stocks;
	
	@OneToMany(fetch=FetchType.LAZY,
			   mappedBy="user",
			   cascade={CascadeType.PERSIST, CascadeType.MERGE,
					    CascadeType.DETACH, CascadeType.REFRESH})
	private List<Share> shares;

	
	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWallet() {
		return wallet;
	}

	public void setWallet(String wallet) {
		this.wallet = wallet;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	public void addStock(Stock stock) {
		
		if (stocks == null) {
			
			stocks = new ArrayList<>();
		}
		
		stocks.add(stock);
	}
	
	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public void addShare(Share share) {
		
		if (shares == null) {
			
			shares = new ArrayList<>();
		}
		
		shares.add(share);
	}

}
