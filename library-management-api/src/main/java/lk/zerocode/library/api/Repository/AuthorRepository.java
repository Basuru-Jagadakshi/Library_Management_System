package lk.zerocode.library.api.Repository;

import lk.zerocode.library.api.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
