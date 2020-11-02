package server;

public class PersonalInfo {
		public String FirstName;
		private String MiddleName;
		private String LastName;
		private String identity;
		public char gender;
		public int age;
		private int salary;
		private String email;
		private String phone;
		public PersonalInfo() {
		}
		public void setFirstName(String FirstName) {
			this.FirstName=FirstName;
		}
		public String getFirstName() {
			return FirstName;
		}
		public void setMiddleName(String MiddleName) {
			this.MiddleName = MiddleName;
		}
		public String getMiddleName() {
			return MiddleName;
		}
		public void setLastName(String LastName) {
			this.LastName = LastName;
		}
		public String getLastName() {
			return LastName;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getEmail() {
			return email;
		}
		public void setIdentity(String identity) {
			this.identity=identity;
		}
		public String getIdentity() {
			return identity;
		}
		public void setGender(char gender) {
			this.gender=gender;
		}
		public char getGender() {
			return gender;
		}
		public void setAge(int age) {
			this.age=age;
		}
		public int getAge() {
			return age;
		}
		public void setSalary(int salary) {
			this.salary=salary;
		}
		public int getSalary() {
			return salary;
		}
		public void setPhone(String phone) {
			this.phone=phone;
		}
		public String getPhone() {
			return phone;
		}
}
