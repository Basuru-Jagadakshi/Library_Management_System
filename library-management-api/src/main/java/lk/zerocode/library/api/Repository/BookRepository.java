package lk.zerocode.library.api.Repository;

import lk.zerocode.library.api.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
