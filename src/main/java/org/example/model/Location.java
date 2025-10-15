package org.example.model;

import lombok.Data;

@Data
public class Location {

  private String building;
  private String roomNumber;
  private int capacity;
  private String description;
  private boolean isAvailable;

  // Конструкторы
  public Location() {
    this.isAvailable = true;
  }

  public Location(String building, String roomNumber, int capacity, String description) {
    this();
    this.building = building;
    this.roomNumber = roomNumber;
    this.capacity = capacity;
    this.description = description;
  }

  // Методы
  public String getFullAddress() {
    return building + ", ауд. " + roomNumber;
  }

  public boolean canAccommodate(int peopleCount) {
    return isAvailable && peopleCount <= capacity;
  }
}