package ca.sheridancollege.kau13223.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor

public class Event {
	
	private Long id;
	@NonNull
	private String title;
	private LocalDate date;
	private LocalTime time;
	private String briefMessage;
	private String additionalInfo;
	
	private boolean enableNotification;
	private LocalTime notificationTime;

}
