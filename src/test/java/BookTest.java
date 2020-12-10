import books.domain.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    Book book = new Book();

    @Before
    public void setUp(){
        book.setAuthor("Азимов");
        book.setBookName("Сами Боги");
        book.setYear("1972");
        book.setGenre("научная фантастика");
        book.setMainCharacters("Ун, Дуа");
    }

    @Test
    public void shouldCreateDeveloperInstanceTest(){
        assertEquals("Азимов", book.getAuthor());
        assertEquals("Сами Боги", book.getBookName());
        assertEquals("1972", book.getYear());
        assertEquals("научная фантастика", book.getGenre());
        assertEquals("Ун, Дуа",book.getMainCharacters());
    }
}



