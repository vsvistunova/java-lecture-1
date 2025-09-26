package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Event {

    protected Long id;
    protected String title;
    protected String description;
    protected User creator;
    protected Location location;
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    protected int maxParticipants;
    protected List<User> participants;

    // Конструктор
    public Event(String title, String description, User creator, Location location,
                LocalDateTime startTime, LocalDateTime endTime, int maxParticipants) {
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxParticipants = maxParticipants;
        this.participants = new ArrayList<>();
    }

    // Абстрактные методы - должны быть реализованы в дочерних классах
    public abstract boolean canUserRegister(User user);
    public abstract String getEventType();

    // Конкретные методы
    public boolean registerParticipant(User user) {
        if (canUserRegister(user) && 
            participants.size() < maxParticipants && 
            !participants.contains(user)) {
            participants.add(user);
            return true;
        }
        return false;
    }

    // Метод с демонстрацией полиморфизма
    public void displayEventInfo() {
        System.out.println("Тип события: " + getEventType());
        System.out.println("Название: " + title);
        System.out.println("Описание: " + description);
        System.out.println("Место: " + location.getFullAddress());
        System.out.println("Время: " + startTime + " - " + endTime);
        System.out.println("Участники: " + participants.size() + "/" + maxParticipants);
    }

    @Override
    public String toString() {
        return title + " (" + getEventType() + ") в " + location.getFullAddress();
    }

}