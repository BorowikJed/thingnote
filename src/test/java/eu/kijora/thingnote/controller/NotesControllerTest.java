package eu.kijora.thingnote.controller;

import eu.kijora.thingnote.model.Note;
import eu.kijora.thingnote.repository.NoteRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc

class NotesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    NoteRepository noteRepository;


    @Test
    void getAllNotes() throws Exception {

        //TODO 1 this init does not work
        //TODO 2 make some custom import.sql for tests
        Note note = new Note();
        note.setText("Text");
        note.setTitle("Title");
        note.setId(123L);
        List<Note> notes= new ArrayList<>();

        when(noteRepository.findAll()).thenReturn(notes);
        this.mockMvc.perform(get("/allnotes")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("text")));
    }

    @Test
    void testGetAllNotes() {
    }

    @Test
    void getNote() {
    }

    @Test
    void deleteNote() {
    }

    @Test
    void addNote() {
    }

    @Test
    void editNote() {
    }
}