package model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    private int age;
    private char sex;
    private LocalDate birth;

    public Employee() {
    }

    public Employee(String firstName, String lastName, int age, char sex, LocalDate birth) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.sex = sex;
	this.birth = birth;
    }

    public Employee(int id, String firstName, String lastName, int age, char sex, LocalDate birth) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.sex = sex;
	this.birth = birth;
    }

    public int getId() {
	return id;
    }

    public String getFirstName() {
	return firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public int getAge() {
	return age;
    }

    public char getSex() {
	return sex;
    }

    public LocalDate getBirth() {
	return birth;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public void setSex(char sex) {
	this.sex = sex;
    }

    public void setBirth(LocalDate birth) {
	this.birth = birth;
    }

    @Override
    public String toString() {
	return String.format("Employee [id=%s, firstName=%s, lastName=%s, age=%s, sex=%s, birth=%s]", id, firstName,
		lastName, age, sex, birth);
    }

}
