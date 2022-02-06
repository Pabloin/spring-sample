package io.github.pabloin.model;


public class Employee {

	private long id;

	private String name;

	private String role;

	private String email;

	public Employee() {
		this(0, "", "", "");
	}

	public Employee(long id, String name) {

		this(id, name, "", "");
	}


	public Employee(long id, String name, String role, String email) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", role='" + role + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
