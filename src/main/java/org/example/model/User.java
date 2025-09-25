package org.example.model;

import java.time.LocalDateTime;

public class User {

  private Long id;
  private String username;
  private String firstName;
  private String lastName;
  private UserType userType;
  private LocalDateTime registrationDate;
  private boolean isActive;

  // Конструкторы
  public User() {
    this.registrationDate = LocalDateTime.now();
    this.isActive = true;
  }

  public User(Long id, String username, String firstName, String lastName, UserType userType) {
    this();
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userType = userType;
  }

  public String getFullName() {
    return firstName + " " + lastName;
  }

  public boolean canCreateEvents() {
    return userType == UserType.TEACHER || userType == UserType.ADMIN;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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

  public UserType getUserType() {
    return userType;
  }

  public void setUserType(UserType userType) {
    this.userType = userType;
  }

  public LocalDateTime getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(LocalDateTime registrationDate) {
    this.registrationDate = registrationDate;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  @Override
  public String toString() {
    return "User{" +
           "id=" + id +
           ", username='" + username + '\'' +
           ", firstName='" + firstName + '\'' +
           ", lastName='" + lastName + '\'' +
           ", userType=" + userType +
           ", registrationDate=" + registrationDate +
           ", isActive=" + isActive +
           '}';
  }
}