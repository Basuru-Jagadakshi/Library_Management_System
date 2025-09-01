package lk.zerocode.library.api.Repository;

import lk.zerocode.library.api.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE " +
            "(:authorName IS NULL OR b.author.authorName = :authorName) AND " +
            "(:categoryName IS NULL OR b.category.categoryName = :categoryName)")
    List<Book> findBooksByAuthorAndCategory(@Param("authorName") String authorName,
                                            @Param("categoryName") String categoryName);
}
