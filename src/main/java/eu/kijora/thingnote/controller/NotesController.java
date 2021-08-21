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

//    @GetMapping("/allnotes")
    public List<Note> getNotes(){
        return Streamable.of(noteRepository.findAll()).toList();
    }

    @GetMapping("/allnotes")
    @ResponseBody
    public String getAllNotes(){
        Iterable<Note> all = noteRepository.findAll();
        Note note = Streamable.of(noteRepository.findAll()).toList().get(0);
        String s = note.toString();
        return s;
//        return Streamable.of(noteRepository.findAll()).toList().get(0).toString();
    }

    @GetMapping("/allnotes2")
    public Note getAllNotes2(){
        Iterable<Note> all = noteRepository.findAll();
        Note note = Streamable.of(noteRepository.findAll()).toList().get(0);
        return note;
//        return Streamable.of(noteRepository.findAll()).toList().get(0).toString();
    }


    @PostMapping("/notes")
    @ResponseBody
    public Note addNote(@RequestBody Note note ){
        Note save = noteRepository.save(note);
        return save;
    }

}
