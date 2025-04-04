package lk.zerocode.library.api.Controller;

import lk.zerocode.library.api.DTO.Request.CreateBorrowedBookRequestDTO;
import lk.zerocode.library.api.Model.*;
import lk.zerocode.library.api.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class InitiateDataController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowBookRepository borrowBookRepository;

    @PostMapping(value = "/initiate-data")
    public void createData(){


        for (int j = 1; j <= 5; j++){
            Category category = new Category();
            category.setCategoryName("category" + j);
            category.setDescription("Description" + j);
            categoryRepository.save(category);


            for (int i = 1; i <= 5; i++){
                Author author = new Author();
                author.setAuthorName("author" + i);
                author.setAuthorBio("bio" + i);
                authorRepository.save(author);

                Book book = new Book();
                book.setTitle("book" + i);
                book.setIsbn("isbn" + i);
                book.setPublishedYear("202" + i);
                book.setTotalCopies(100 + i);
                book.setAvailableCopies(100 + i);
                book.setAuthor(author);
                book.setCategory(category);
                bookRepository.save(book);
            }
        }



        for(int k = 1; k <= 5; k++){
            Member member = new Member();
            member.setMemberName("member" + k);
            member.setEmail("member" + k + "@gmail.com");
            memberRepository.save(member);
        }
    }
}
