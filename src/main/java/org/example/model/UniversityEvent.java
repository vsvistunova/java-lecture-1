package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class UniversityEvent extends Event {

  private String organizerDepartment;
  private boolean requiresRegistration;

  public UniversityEvent(String title, String description, User creator, Location location,
      LocalDateTime startTime, LocalDateTime endTime, int maxParticipants,
      String organizerDepartment, boolean requiresRegistration) {
    super(title, description, creator, location, startTime, endTime, maxParticipants);
    this.organizerDepartment = organizerDepartment;
    this.requiresRegistration = requiresRegistration;
  }

  @Override
  public boolean canUserRegister(User user) {
    // На мероприятие могут записаться все активные пользователи
    return user.isActive();
  }

  @Override
  public String getEventType() {
    return "Университетское мероприятие";
  }

  // Специфичные методы
  public boolean isOpenForAll() {
    return !requiresRegistration;
  }

  @Override
  public String toString() {
    String base = super.toString();
    return base + " [Организатор: " + organizerDepartment + "]";
  }

}