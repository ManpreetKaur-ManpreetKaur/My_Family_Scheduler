package ca.sheridancollege.kau13223.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class CalendarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetEventList() throws Exception {
        this.mockMvc.perform(get("/api/v1/events"))
            .andExpect(status().isOk());
    }

    
    @Test
    public void testGetIndividualEvent() throws Exception {
        Long id = 1L; 
        this.mockMvc.perform(get("/api/v1/events/" + id))
            .andExpect(status().isOk());
    }

    
    @Test
    public void testDeleteAllEvents() throws Exception {
        this.mockMvc.perform(delete("/api/v1/events"))
            .andExpect(status().isOk());
    }

    
    
}

