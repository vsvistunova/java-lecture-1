package org.example.model;

import java.time.LocalDateTime;

public class AdminMeetingEvent extends Event {

    private boolean mandatory;

    public AdminMeetingEvent(
            String title, String description, User creator, Location location,
            LocalDateTime startTime, LocalDateTime endTime, int maxParticipants, boolean isMandatory
    ) {
        super(title, description, creator, location, startTime, endTime, maxParticipants);
        this.mandatory = isMandatory;
    }

    @Override
    public boolean canUserRegister(User user) {
        return user.getUserType().equals(UserType.ADMIN) || user.getUserType().equals(UserType.TEACHER);
    }

    @Override
    public String getEventType() {
        return "Admin Meeting";
    }

    @Override
    public void displayEventInfo() {
        super.displayEventInfo();
        if (mandatory) {
            System.out.println("Обязательно для посещения");
        }
    }

}
