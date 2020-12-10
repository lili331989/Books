package books.repos;

import books.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findByBookName (String BookName);
}