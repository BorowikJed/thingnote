package eu.kijora.thingnote.controller;

import eu.kijora.thingnote.model.Note;
import eu.kijora.thingnote.repository.NoteRepository;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<Note> getAllNotes() {
        Iterable<Note> all = noteRepository.findAll();
        return Streamable.of(noteRepository.findAll()).toList();
    }

    @PostMapping("/notes")
    @ResponseBody
    public Note addNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @PatchMapping("/notes/{id}")
    @ResponseBody
    public ResponseEntity<?> editNote(@RequestBody Note note, @PathVariable Long id) {
        Optional<Note> optionalNote = noteRepository.findById(id);

        if (optionalNote.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else {
            optionalNote.get().setTitle(note.getTitle());
            optionalNote.get().setText(note.getText());
        }
        Note save = noteRepository.save(optionalNote.get());
        return ResponseEntity.ok(save);
    }

}
