package com.hansung.Project1;

import java.util.Arrays;

public class Book {
	private String name;
	private String genre;
	private String date;
	private String code;
	private String number;
	private String price;
	private String publisher;
	private String state;
	private String lending;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String name, String genre, String date, String code, String number, String price, String publisher,
			String state, String lending) {
		super();
		this.name = name;
		this.genre = genre;
		this.date = date;
		this.code = code;
		this.number = number;
		this.price = price;
		this.publisher = publisher;
		this.state = state;
		this.lending = lending;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLending() {
		return lending;
	}

	public void setLending(String lending) {
		this.lending = lending;
	}
	
	@Override
	public String toString() {
		return "Book [name=" + name+ ", genre=" + genre + ", date=" + date + ", code=" + code + ", number=" + number
				+ ", price=" + price + ", publisher=" + publisher + ", state=" + state + ", lending=" + lending+ "]";
	}
}
