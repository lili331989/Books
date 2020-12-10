package books.controller;

import au.com.bytecode.opencsv.CSVReader;
import books.domain.Book;
import books.exception.ResourceNotFoundException;
import books.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepo bookRepo;

    @GetMapping
    public String bookList (Model model) {
        model.addAttribute("books",bookRepo.findAll());
        return "bookList";
    }

    @GetMapping ("/delete/{book}")
    public String bookPageDelete(@PathVariable Book book, Model model) throws ResourceNotFoundException {
        model.addAttribute("book", book);
        if (book==null){
            throw new ResourceNotFoundException("Данный объект не существует, обновите таблицу");
        }
        return "bookDelete";
    }

    @GetMapping("/edit/{book}")
    public String movieEditForm (@PathVariable Book book, Model model) throws ResourceNotFoundException {
        model.addAttribute("book", book);
        if (book==null){
            throw new ResourceNotFoundException("Данный объект не существует, обновите таблицу");
        }
        return "bookEdit";
    }

    @GetMapping("/add")
    public String bookPageAdd (Model model) {
        return "bookAdd";
    }


    @PostMapping("/add")
    public String bookAdd(
            @RequestParam String bookName,
            @RequestParam String year,
            @RequestParam String author,
            @RequestParam String genre,
            @RequestParam String mainCharacters
    ){
        Book book= new Book (bookName,year,author,genre,mainCharacters);
        bookRepo.save(book);
        return "redirect:/books";
    }

    @PostMapping("/edit")
    public String bookEdit(
            @RequestParam Long bookId,
            @RequestParam String bookName,
            @RequestParam String year,
            @RequestParam String author,
            @RequestParam String genre,
            @RequestParam String mainCharacters
    ) throws ResourceNotFoundException{
        Optional<Book> result=bookRepo.findById(bookId);
        if (!result.isPresent()) throw new ResourceNotFoundException("Данный объект не существует, обновите таблицу");
        Book book=result.get();
        book.setBookName(bookName);
        book.setYear(year);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setMainCharacters(mainCharacters);
        bookRepo.save(book);
        return "redirect:/books";
    }


    @PostMapping("/delete")
    public String bookDelete (@RequestParam Long bookId){
        bookRepo.deleteById(bookId);
        return "redirect:/books";
    }

    @PostMapping("/addCSV")
    public String bookAddCSV (@RequestParam ("file") MultipartFile file) throws ResourceNotFoundException {
        if (file.isEmpty()) {
            throw new ResourceNotFoundException("Файл не содержит данных");
        }
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
            String[] nextLine;
            ArrayList<Book> bookList = new ArrayList<>();

            while ((nextLine = reader.readNext()) != null) {
                bookList.add(new Book(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4]));
            }
            for (Book book : bookList) {
                bookRepo.save(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("Ошибка при загрузке файла");
        }
        return "redirect:/books";
    }
}
