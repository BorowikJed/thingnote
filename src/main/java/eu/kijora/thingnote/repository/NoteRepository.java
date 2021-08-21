package eu.kijora.thingnote.repository;

import eu.kijora.thingnote.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
