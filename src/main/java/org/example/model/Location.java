package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

    @Override
  public String toString() {
    return "Location{" +
           "building='" + building + '\'' +
           ", roomNumber='" + roomNumber + '\'' +
           ", capacity=" + capacity +
           ", description='" + description + '\'' +
           ", isAvailable=" + isAvailable +
           '}';
  }
}