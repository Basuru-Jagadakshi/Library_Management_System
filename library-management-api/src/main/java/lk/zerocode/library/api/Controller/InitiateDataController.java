package lk.zerocode.library.api.Controller;

//import lk.zerocode.library.api.DTO.Request.CreateBorrowedBookRequestDTO;
//import lk.zerocode.library.api.Model.*;
//import lk.zerocode.library.api.Repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//
//@RestController
//public class InitiateDataController {
//
//    @Autowired
//    private AuthorRepository authorRepository;
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Autowired
//    private BorrowBookRepository borrowBookRepository;
//
//    @PostMapping(value = "/initiate-data")
//    public void createData(){
//
//
//        for (int j = 1; j <= 5; j++){
//            Category category = new Category();
//            category.setCategoryName("category" + j);
//            category.setDescription("Description" + j);
//            categoryRepository.save(category);
//
//
//            for (int i = 1; i <= 5; i++){
//                Author author = new Author();
//                author.setAuthorName("author" + i);
//                author.setAuthorBio("bio" + i);
//                authorRepository.save(author);
//
//                Book book = new Book();
//                book.setTitle("book" + i);
//                book.setIsbn("isbn" + i);
//                book.setPublishedYear("202" + i);
//                book.setTotalCopies(100 + i);
//                book.setAvailableCopies(100 + i);
//                book.setDescription("In a world where secrets can change destinies, Elara stumbles upon a hidden journal that could rewrite history itself. Haunted by her past and pursued by those who will stop at nothing to keep the truth buried, she must navigate a labyrinth of lies, forbidden love, and forgotten legends. Whispers of the Forgotten is a spellbinding journey of courage, mystery, and the unbreakable bonds that define us. Perfect for fans of gripping thrillers and unforgettable adventures.");
//                book.setAuthor(author);
//                book.setCategory(category);
//                bookRepository.save(book);
//            }
//        }
//
//
//
//        for(int k = 1; k <= 5; k++){
//            Member member = new Member();
//            member.setMemberName("member" + k);
//            member.setEmail("member" + k + "@gmail.com");
//            memberRepository.save(member);
//        }
//    }
//}


import lk.zerocode.library.api.Model.*;
import lk.zerocode.library.api.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class InitiateDataController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping(value = "/initiate-data")
    public void createData(){

        // Categories
        List<String> categories = Arrays.asList("Novels", "Fairy Tales", "Science Fiction", "Mystery", "Biography");
        for(String catName : categories){
            Category category = new Category();
            category.setCategoryName(catName);
            category.setDescription("Collection of " + catName);
            categoryRepository.save(category);
        }

        // Authors
        List<String> authors = Arrays.asList(
                "J.K. Rowling", "George Orwell", "J.R.R. Tolkien", "Agatha Christie", "Isaac Asimov",
                "C.S. Lewis", "Mark Twain", "Jane Austen", "Stephen King", "Ernest Hemingway"
        );
        for(String authorName : authors){
            Author author = new Author();
            author.setAuthorName(authorName);
            author.setAuthorBio("Biography of " + authorName);
            authorRepository.save(author);
        }

        // Book details
        List<Book> books = Arrays.asList(
                createBook("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Novels", "1997", 120, 120,
                        "The first book in the Harry Potter series where Harry discovers he is a wizard."),
                createBook("1984", "George Orwell", "Science Fiction", "1949", 100, 100,
                        "A dystopian novel about totalitarian regime and surveillance."),
                createBook("The Hobbit", "J.R.R. Tolkien", "Novels", "1937", 80, 80,
                        "Bilbo Baggins goes on an unexpected journey with dwarves."),
                createBook("Murder on the Orient Express", "Agatha Christie", "Mystery", "1934", 60, 60,
                        "Hercule Poirot investigates a murder on a luxurious train."),
                createBook("Foundation", "Isaac Asimov", "Science Fiction", "1951", 90, 90,
                        "Epic saga about the collapse and rebirth of a galactic empire."),
                createBook("The Lion, the Witch and the Wardrobe", "C.S. Lewis", "Fairy Tales", "1950", 70, 70,
                        "Four children discover the magical world of Narnia."),
                createBook("Adventures of Huckleberry Finn", "Mark Twain", "Novels", "1884", 50, 50,
                        "The adventures of a young boy along the Mississippi River."),
                createBook("Pride and Prejudice", "Jane Austen", "Novels", "1813", 60, 60,
                        "A classic novel exploring manners, upbringing, and love in early 19th century England."),
                createBook("The Shining", "Stephen King", "Mystery", "1977", 55, 55,
                        "A family heads to an isolated hotel where supernatural events occur."),
                createBook("The Old Man and the Sea", "Ernest Hemingway", "Novels", "1952", 40, 40,
                        "An old fisherman struggles with a giant marlin in the Gulf Stream."),
                createBook("Alice's Adventures in Wonderland", "Lewis Carroll", "Fairy Tales", "1865", 70, 70,
                        "Alice falls down a rabbit hole into a whimsical world."),
                createBook("Frankenstein", "Mary Shelley", "Science Fiction", "1818", 65, 65,
                        "A scientist creates a sentient creature, with tragic consequences."),
                createBook("The Chronicles of Narnia: Prince Caspian", "C.S. Lewis", "Fairy Tales", "1951", 60, 60,
                        "The Pevensie siblings return to Narnia to help Prince Caspian reclaim his throne."),
                createBook("Emma", "Jane Austen", "Novels", "1815", 55, 55,
                        "A young woman's misguided matchmaking efforts lead to comedic misunderstandings."),
                createBook("Carrie", "Stephen King", "Mystery", "1974", 50, 50,
                        "A bullied girl discovers her terrifying telekinetic powers."),
                createBook("Animal Farm", "George Orwell", "Novels", "1945", 75, 75,
                        "An allegorical novella reflecting events leading up to the Russian Revolution."),
                createBook("The Fellowship of the Ring", "J.R.R. Tolkien", "Novels", "1954", 85, 85,
                        "Frodo begins his journey to destroy the One Ring."),
                createBook("And Then There Were None", "Agatha Christie", "Mystery", "1939", 65, 65,
                        "Ten strangers are invited to an island, where a killer awaits."),
                createBook("I, Robot", "Isaac Asimov", "Science Fiction", "1950", 70, 70,
                        "A collection of short stories exploring robotics and ethics."),
                createBook("Peter Pan", "J.M. Barrie", "Fairy Tales", "1911", 60, 60,
                        "The adventures of a boy who never grows up in Neverland.")
        );

        List<Author> authorList = authorRepository.findAll();
        List<Category> categoryList = categoryRepository.findAll();

        // Save books with references
        for(Book book : books){
            // Link book to author object
            Author author = authorList.stream()
                    .filter(a -> a.getAuthorName().equals(book.getAuthor().getAuthorName()))
                    .findFirst()
                    .orElse(null);
            book.setAuthor(author);

            // Link book to category object
            Category category = categoryList.stream()
                    .filter(c -> c.getCategoryName().equals(book.getCategory().getCategoryName()))
                    .findFirst()
                    .orElse(null);
            book.setCategory(category);

            bookRepository.save(book);
        }

        // Create members
        List<Member> members = Arrays.asList(
                createMember("Alice Johnson", "alice.johnson@gmail.com"),
                createMember("Bob Smith", "bob.smith@gmail.com"),
                createMember("Carol Davis", "carol.davis@gmail.com"),
                createMember("David Wilson", "david.wilson@gmail.com"),
                createMember("Emma Brown", "emma.brown@gmail.com"),
                createMember("Frank Miller", "frank.miller@gmail.com"),
                createMember("Grace Lee", "grace.lee@gmail.com"),
                createMember("Henry Clark", "henry.clark@gmail.com"),
                createMember("Isabel Lewis", "isabel.lewis@gmail.com"),
                createMember("Jack Walker", "jack.walker@gmail.com")
        );

        memberRepository.saveAll(members);
    }

    private Book createBook(String title, String authorName, String categoryName, String year, int totalCopies, int availableCopies, String description){
        Book book = new Book();
        book.setTitle(title);
        Author author = new Author();
        author.setAuthorName(authorName);
        book.setAuthor(author);
        Category category = new Category();
        category.setCategoryName(categoryName);
        book.setCategory(category);
        book.setPublishedYear(year);
        book.setTotalCopies(totalCopies);
        book.setAvailableCopies(availableCopies);
        book.setDescription(description);
        book.setIsbn("ISBN" + (1000 + title.hashCode() % 10000));
        return book;
    }

    private Member createMember(String name, String email){
        Member member = new Member();
        member.setMemberName(name);
        member.setEmail(email);
        return member;
    }
}

