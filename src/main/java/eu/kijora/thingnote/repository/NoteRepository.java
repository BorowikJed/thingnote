package eu.kijora.thingnote.repository;

import eu.kijora.thingnote.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
