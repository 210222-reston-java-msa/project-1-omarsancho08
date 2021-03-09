package com.revature.models;

import javax.management.relation.Role;

public class Users {

	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int role;
		
		public Users() {
			
		}
		
		

		public Users(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}



		public Users(int id, String firstName, String lastName, String email) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
		}



		public Users(String username, String password, String firstName, String lastName, String email, int role) {
			super();
			this.username = username;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.role = role;
		}

		public Users(int id, String username, String password, String firstName, String lastName, String email,
				int role) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.role = role;
		}

		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}

		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
		}

		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}

		/**
		 * @return the firstName
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * @param firstName the firstName to set
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		/**
		 * @return the lastName
		 */
		public String getLastName() {
			return lastName;
		}

		/**
		 * @param lastName the lastName to set
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * @return the role
		 */
		public int getRole() {
			return role;
		}

		/**
		 * @param role the role to set
		 */
		public void setRole(int role) {
			this.role = role;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + id;
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + role;
			result = prime * result + ((username == null) ? 0 : username.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Users other = (Users) obj;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (id != other.id)
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (role != other.role)
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Users [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", email=" + email + ", role=" + role + "]";
		}

		

}