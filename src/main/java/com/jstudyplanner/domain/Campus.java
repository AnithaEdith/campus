package com.jstudyplanner.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Campus")
public class Campus implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;

	@Column(name="code")
	private String code;

	@Column(name="title")
	private String title;

	@Column(name="enabled")
	private Byte enabled;

	@Column(name="address")
	private String address;

	@Column(name="phone")
	private String phone;

	@Column(name="description")
	private String description;

	public Campus(Long id, String code, String title, Byte enabled, String address, String phone, String description) {
		this.id = id;
		this.code = code;
		this.title = title;
		this.enabled = enabled;
		this.address = address;
		this.phone = phone;
		this.description = description;
	}

	public Campus() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Byte getEnabled() {
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Campus{" +
				"id=" + id +
				", code='" + code + '\'' +
				", title='" + title + '\'' +
				", enabled=" + enabled +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}