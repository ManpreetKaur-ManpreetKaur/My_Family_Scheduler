package ca.sheridancollege.kau13223.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ca.sheridancollege.kau13223.beans.Event;

@SpringBootTest
public class DatabaseAccessTest {

    @Autowired
    private DatabaseAccess da;

    
    @Test
    public void testSaveandGetEvent() {
        
        Event event = new Event();
        event.setTitle("Test Event");
        event.setDate(LocalDate.parse("2023-12-01"));
        event.setTime(LocalTime.parse("12:30:00"));
        event.setBriefMessage("Test brief message");
        event.setAdditionalInfo("Test additional info");
        event.setEnableNotification(true);
        event.setNotificationTime(LocalTime.parse("12:30:00"));

        
        Long eventId = da.save(event);
        assertNotNull(eventId);

        Event savedEvent = da.findById(eventId);

        
        assertNotNull(savedEvent);
        assertEquals(event.getTitle(), savedEvent.getTitle());

      
    }
}

