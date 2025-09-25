package org.example.model;

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

  public String getBuilding() {
    return building;
  }

  public void setBuilding(String building) {
    this.building = building;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
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