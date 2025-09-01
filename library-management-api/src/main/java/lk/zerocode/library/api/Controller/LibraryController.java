package lk.zerocode.library.api.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import lk.zerocode.library.api.DTO.Request.*;
import lk.zerocode.library.api.DTO.Response.*;
import lk.zerocode.library.api.Exceptions.*;
import lk.zerocode.library.api.Model.Book;
import lk.zerocode.library.api.Model.Category;
import lk.zerocode.library.api.Service.AiBookService;
import lk.zerocode.library.api.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/library")
@Tag(name = "LibraryController", description = "Perform operations on Library")
@CrossOrigin(origins = "*")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private AiBookService aiBookService;


    //Author methods
    @Operation(
            summary = "POST operation on authors",
            description = "It is used to save authors in the database"
    )
    @PostMapping(value = "/authors")
    public void saveAuthor(@Valid @RequestBody CreateAuthorRequestDTO createAuthorRequestDTO){
        libraryService.saveAuthor(createAuthorRequestDTO);
    }

    @Operation(
            summary = "GET operation by using author id",
            description = "It is used to retrieve authors from the database"
    )
    @GetMapping(value = "/authors/{id}")
    public AuthorResponseDTO getAuthorById(@PathVariable Long id) throws AuthorNotFoundException{
        return libraryService.getAuthorById(id);
    }

    @Operation(
            summary = "GET operation on author",
            description = "It is used to retrieve authors from the database"
    )
    @GetMapping(value = "/authors")
    public List<AuthorResponseDTO> getAuthors(){
        return libraryService.getAuthors();
    }

    @Operation(
            summary = "DELETE operation on author",
            description = "It is used to delete authors from the database"
    )
    @DeleteMapping(value = "/authors/{id}")
    public void deleteAuthor(@PathVariable Long id) throws AuthorNotFoundException{
        libraryService.deleteAuthor(id);
    }

    @Operation(
            summary = "PUT operation on author",
            description = "It is used to update authors in the database"
    )
    @PutMapping(value = "/authors")
    public AuthorResponseDTO updateAuthor(@Valid @RequestBody UpdateAuthorRequestDTO updateAuthorRequestDTO) throws AuthorNotFoundException{
        return libraryService.updateAuthor(updateAuthorRequestDTO);
    }


    //Category methods
    @PostMapping(value = "/categories")
    @CachePut(cacheNames = "categories", key = "#result.id")
    public Category saveCategory(@Valid @RequestBody CreateCategoryRequestDTO createCategoryRequestDTO){
        return libraryService.saveCategory(createCategoryRequestDTO);
    }

    @GetMapping(value = "/categories/{id}")
    @Cacheable(value = "categories", key = "#id")
    public CategoryResponseDTO getCategoryById(@PathVariable Long id) throws CategoryNotFoundException{
        return libraryService.getCategoryById(id);
    }

    @GetMapping(value = "/categories")
    @Cacheable(value = "categories", key = "'all'")
    public List<CategoryResponseDTO> getAllCategory(){
        return libraryService.getAllCategory();
    }

    @DeleteMapping(value = "/categories/{id}")
    @CacheEvict(value = "categories", key = "#id")
    public void deleteCategory(@PathVariable Long id) throws CategoryNotFoundException{
        libraryService.deleteCategory(id);
    }

    @PutMapping(value = "/categories")
    @CachePut(value = "categories", key = "#updateCategoryRequestDTO.id")
    public CategoryResponseDTO updateCategory(@Valid @RequestBody UpdateCategoryRequestDTO updateCategoryRequestDTO) throws CategoryNotFoundException{
        return libraryService.updateCategory(updateCategoryRequestDTO);
    }




    //Member methods
    @PostMapping(value = "/members")
    public void saveMember(@Valid @RequestBody CreateMemberRequestDTO createMemberRequestDTO){
        libraryService.saveMember(createMemberRequestDTO);
    }

    @GetMapping(value = "/members/{id}")
    public MemberResponseDTO getMemberById(@PathVariable Long id) throws MemberNotFoundException{
        return libraryService.getMemberById(id);
    }

    @GetMapping(value = "/members")
    public List<MemberResponseDTO> getMembers(){
        return libraryService.getMembers();
    }

    @DeleteMapping(value = "/members/{id}")
    public void deleteMember(@PathVariable Long id) throws MemberNotFoundException{
        libraryService.deleteMember(id);
    }

    @PutMapping(value = "/members")
    public MemberResponseDTO updateMember(@Valid @RequestBody UpdateMemberRequestDTO updateMemberRequestDTO) throws MemberNotFoundException{
        return libraryService.updateMember(updateMemberRequestDTO);
    }



    //Book methods
    @PostMapping(value = "/books")
    public void saveBook(@Valid @RequestBody CreateBookRequestDTO createBookRequestDTO) throws AuthorNotFoundException, CategoryNotFoundException{
        libraryService.saveBook(createBookRequestDTO);
    }

    @GetMapping(value = "/books/{id}")
    public BookResponseDTO getBookById(@PathVariable Long id) throws BookNotFoundException{
        return libraryService.getBookById(id);
    }

    @GetMapping(value = "/books")
    public List<BookResponseDTO> getAllBooks(){
        return libraryService.getAllBooks();
    }

    @DeleteMapping(value = "/books/{id}")
    public void deleteBookById(@PathVariable Long id) throws BookNotFoundException{
        libraryService.deleteBookById(id);
    }

    @PutMapping(value = "/books")
    public BookResponseDTO updateBookById(@Valid @RequestBody UpdateBookRequestDTO updateBookRequestDTO) throws BookNotFoundException, AuthorNotFoundException, CategoryNotFoundException{
        return libraryService.updateBookById(updateBookRequestDTO);
    }




    //BorrowedBooks method
    @PostMapping(value = "/borrowed-books")
    public void saveBorrowedBook(@Valid @RequestBody CreateBorrowedBookRequestDTO createBorrowedBookRequestDTO) throws MemberNotFoundException, BookNotFoundException, NoAvailableCopiesException{
        libraryService.saveBorrowedBook(createBorrowedBookRequestDTO);
    }

    @GetMapping(value = "/borrowed-books/{id}")
    public BorrowedBookResponseDTO getBorrowedBookById(@PathVariable Long id) throws BorrowBookNotFoundException{
        return libraryService.getBorrowedBookById(id);
    }

    @GetMapping(value = "/borrowed-books")
    public List<BorrowedBookResponseDTO> getBorrowedBook(){
        return libraryService.getBorrowedBook();
    }

    @DeleteMapping(value = "/borrowed-books/{id}")
    public void deleteBorrowedBookById(@PathVariable Long id) throws BorrowBookNotFoundException{
        libraryService.deleteBorrowedBookById(id);
    }

    @PutMapping(value = "/borrowed-books")
    public BorrowedBookResponseDTO updateBorrowedBookById(@Valid @RequestBody UpdateBorrowedBookRequestDTO updateBorrowedBookRequestDTO) throws BorrowBookNotFoundException, MemberNotFoundException, BookNotFoundException{
        return libraryService.updateBorrowedBookById(updateBorrowedBookRequestDTO);
    }




    //User Functions
    @GetMapping("/filter")
    public List<Book> filterBooks(
            @RequestParam(required = false) String authorName,
            @RequestParam(required = false) String categoryName) {
        return libraryService.getBooksByAuthorAndCategory(authorName, categoryName);
    }



    //AI Feature
    @GetMapping("/recommend")
    public String recommendBooks(@RequestParam String topic) {
        return aiBookService.getSuggestedBooks(topic);
    }
}
