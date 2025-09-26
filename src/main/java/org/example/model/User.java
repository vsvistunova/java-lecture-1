package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
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

}