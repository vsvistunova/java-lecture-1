package org.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@Data
public class AdminMeetingEvent extends Event{
    protected boolean mandatory;

    public AdminMeetingEvent(String title, String description, User creator, Location location, LocalDateTime startTime, LocalDateTime endTime, int maxParticipants) {
        super(title, description, creator, location, startTime, endTime, maxParticipants);
    }

    @Override
    public boolean canUserRegister(User user) {
        return user.getUserType() == UserType.ADMIN ||
                user.getUserType() == UserType.TEACHER;
    }

    @Override
    public String getEventType() {
        return "Admin Meeting";
    }

    @Override
    public void displayEventInfo(){
        super.displayEventInfo();
        if (mandatory) {
            System.out.println("Обязательно для посещения");
        }
    }
}
