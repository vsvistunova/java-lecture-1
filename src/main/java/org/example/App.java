package org.example;

import java.time.LocalDateTime;

import org.example.model.*;

public class App {

  public static void main(String[] args) {
    demonstrateOOP();
  }

  public static void demonstrateOOP() {
    // Создаем пользователей
    User student = new User(1L, "ivanov", "Иван", "Иванов", UserType.STUDENT);
    User teacher = new User(2L, "petrova", "Мария", "Петрова", UserType.TEACHER);
    User admin = new User(3L, "sidorov", "Алексей", "Сидоров", UserType.ADMIN);

    // Создаем локации
    Location lectureHall = new Location("Главный корпус", "101", 50, "Аудитория для лекций");
    Location conferenceRoom = new Location("Новый корпус", "Актовый зал", 200, "Актовый зал");

    // Создаем события разных типов (полиморфизм!)
    Event lecture = new Lecture("Введение в ООП", "Программирование", teacher, lectureHall,
        LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(2),
        50, true);

    Event conference = new UniversityEvent("Научная конференция",
        "Ежегодная конференция по компьютерным наукам", admin, conferenceRoom,
        LocalDateTime.now().plusDays(5), LocalDateTime.now().plusDays(5).plusHours(6),
        150, "Факультет информатики", true);

    Event meeting = new AdminMeetingEvent("Административное мероприятие",
            "Собрание преподавателей", admin, conferenceRoom, LocalDateTime.now().plusDays(5),
            LocalDateTime.now().plusDays(5).plusHours(1), 20, true);

    // Демонстрация полиморфизма
    System.out.println("=== ДЕМОНСТРАЦИЯ ООП ===");

    Event[] events = {lecture, conference, meeting};
    for (Event event : events) {
      System.out.println("\n--- " + event.getEventType() + " ---");
      event.displayEventInfo();

      // Пробуем записать разных пользователей
      System.out.println("\nПопытка записи:");
      System.out.println("Студент может записаться: " + event.canUserRegister(student));
      System.out.println("Преподаватель может записаться: " + event.canUserRegister(teacher));

      // Регистрируем участников
      if (event.canUserRegister(student)) {
        event.registerParticipant(student);
        System.out.println("Студент записался на событие!");
      }
    }

    // Демонстрация наследования
    System.out.println("\n=== ПРОВЕРКА ТИПОВ ===");
    System.out.println("Лекция является Event: " + (lecture instanceof Event));
    System.out.println("Лекция является Lecture: " + (lecture instanceof Lecture));
    System.out.println(
        "Конференция является UniversityEvent: " + (conference instanceof UniversityEvent));
    System.out.println("Собрание является AdminMeeting: " + (meeting instanceof AdminMeetingEvent));
  }
}
