package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Lecture extends Event {

  private String subject;
  private boolean isMandatory;

  public Lecture(String title, String subject, User creator, Location location,
      LocalDateTime startTime, LocalDateTime endTime, int maxParticipants,
      boolean isMandatory) {
    super(title, "Лекция по предмету: " + subject, creator, location, startTime, endTime,
        maxParticipants);
    this.subject = subject;
    this.isMandatory = isMandatory;
  }

  @Override
  public boolean canUserRegister(User user) {
    // На лекцию могут записаться только студенты
    return user.getUserType() == UserType.STUDENT;
  }

  @Override
  public String getEventType() {
    return "Лекция";
  }

  // Специфичные для лекции методы
  public void markAsMandatory() {
    this.isMandatory = true;
  }

    @Override
  public String toString() {
    return super.toString() + " [Предмет: " + subject + "]";
  }

}