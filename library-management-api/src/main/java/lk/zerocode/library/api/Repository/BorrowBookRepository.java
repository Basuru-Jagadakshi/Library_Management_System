package lk.zerocode.library.api.Repository;

import lk.zerocode.library.api.Model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowBookRepository extends JpaRepository<BorrowBook, Long> {
}
