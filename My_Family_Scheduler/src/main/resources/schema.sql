CREATE TABLE calendar (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    time TIME NOT NULL,
    briefMessage VARCHAR(255),
    additionalInfo VARCHAR(255),
    enableNotification BOOLEAN NOT NULL,
    notificationTime TIME,
    UNIQUE (date, time)  -- Ensure no duplicate entries for the same date and time
);
