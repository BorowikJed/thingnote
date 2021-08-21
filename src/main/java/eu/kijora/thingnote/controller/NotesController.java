package eu.kijora.thingnote.controller;

import eu.kijora.thingnote.model.Note;
import eu.kijora.thingnote.repository.NoteRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NotesController {

    private final NoteRepository noteRepository;

    public NotesController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/allnotes")
    @ResponseBody
    public List<Note> getAllNotes(){
        Iterable<Note> all = noteRepository.findAll();
        return Streamable.of(noteRepository.findAll()).toList();
    }

    @PostMapping("/notes")
    @ResponseBody
    public Note addNote(@RequestBody Note note ){
        return noteRepository.save(note);
    }

}
