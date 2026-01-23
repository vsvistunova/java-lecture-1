package org.example.model;

import lombok.Getter;

import java.time.LocalDateTime;
public class AdminMeetingEvent extends Event{
    private String organizerAdmin;
    @Getter
    private boolean isMandatory;
public AdminMeetingEvent(String title, String description, User creator, Location location,
                         LocalDateTime startTime, LocalDateTime endTime, int maxParticipants,  boolean isMandatory) {
    super(title, description, creator, location, startTime, endTime, maxParticipants);
    if (creator.getUserType() != UserType.ADMIN) {
        throw new IllegalArgumentException("Admin Meeting может созвать только администратор");
    }
    this.isMandatory = isMandatory;
}

    @Override
    public boolean canUserRegister(User user) {
        return user.getUserType()==UserType.ADMIN
                || user.getUserType()==UserType.TEACHER;
    }

    @Override
    public String getEventType() {
        return "Admin Meeting";
    }
    public void markAsMandatory() {
        this.isMandatory = true;
    }

    @Override
    public void displayEventInfo() {
    super.displayEventInfo();
    if (isMandatory) {
        System.out.println("Обязательно для посещения");
    }
    }
}
