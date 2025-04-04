package lk.zerocode.library.api.Controller;

import jakarta.validation.Valid;
import lk.zerocode.library.api.DTO.Request.*;
import lk.zerocode.library.api.DTO.Response.*;
import lk.zerocode.library.api.Exceptions.*;
import lk.zerocode.library.api.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;


    //Author methods
    @PostMapping(value = "/save-authors")
    public void saveAuthor(@Valid @RequestBody CreateAuthorRequestDTO createAuthorRequestDTO){
        libraryService.saveAuthor(createAuthorRequestDTO);
    }

    @GetMapping(value = "get-authors/{id}")
    public AuthorResponseDTO getAuthorById(@PathVariable Long id) throws AuthorNotFoundException{
        return libraryService.getAuthorById(id);
    }

    @GetMapping(value = "/get-authors")
    public List<AuthorResponseDTO> getAuthors(){
        return libraryService.getAuthors();
    }

    @DeleteMapping(value = "/delete-authors/{id}")
    public void deleteAuthor(@PathVariable Long id) throws AuthorNotFoundException{
        libraryService.deleteAuthor(id);
    }

    @PutMapping(value = "/update-authors")
    public AuthorResponseDTO updateAuthor(@Valid @RequestBody UpdateAuthorRequestDTO updateAuthorRequestDTO) throws AuthorNotFoundException{
        return libraryService.updateAuthor(updateAuthorRequestDTO);
    }


    //Category methods
    @PostMapping(value = "/save-category")
    public void saveCategory(@Valid @RequestBody CreateCategoryRequestDTO createCategoryRequestDTO){
        libraryService.saveCategory(createCategoryRequestDTO);
    }

    @GetMapping(value = "/get-category/{id}")
    public CategoryResponseDTO getCategoryById(@PathVariable Long id) throws CategoryNotFoundException{
        return libraryService.getCategoryById(id);
    }

    @GetMapping(value = "/get-categories")
    public List<CategoryResponseDTO> getAllCategory(){
        return libraryService.getAllCategory();
    }

    @DeleteMapping(value = "delete-categories/{id}")
    public void deleteCategory(@PathVariable Long id) throws CategoryNotFoundException{
        libraryService.deleteCategory(id);
    }

    @PutMapping(value = "/update-category")
    public CategoryResponseDTO updateCategory(@Valid @RequestBody UpdateCategoryRequestDTO updateCategoryRequestDTO) throws CategoryNotFoundException{
        return libraryService.updateCategory(updateCategoryRequestDTO);
    }




    //Member methods
    @PostMapping(value = "/save-members")
    public void saveMember(@Valid @RequestBody CreateMemberRequestDTO createMemberRequestDTO){
        libraryService.saveMember(createMemberRequestDTO);
    }

    @GetMapping(value = "/get-members/{id}")
    public MemberResponseDTO getMemberById(@PathVariable Long id) throws MemberNotFoundException{
        return libraryService.getMemberById(id);
    }

    @GetMapping(value = "/get-members")
    public List<MemberResponseDTO> getMembers(){
        return libraryService.getMembers();
    }

    @DeleteMapping(value = "/delete-members/{id}")
    public void deleteMember(@PathVariable Long id) throws MemberNotFoundException{
        libraryService.deleteMember(id);
    }

    @PutMapping(value = "/update-members")
    public MemberResponseDTO updateMember(@Valid @RequestBody UpdateMemberRequestDTO updateMemberRequestDTO) throws MemberNotFoundException{
        return libraryService.updateMember(updateMemberRequestDTO);
    }



    //Book methods
    @PostMapping(value = "/save-books")
    public void saveBook(@Valid @RequestBody CreateBookRequestDTO createBookRequestDTO) throws AuthorNotFoundException, CategoryNotFoundException{
        libraryService.saveBook(createBookRequestDTO);
    }

    @GetMapping(value = "/get-books/{id}")
    public BookResponseDTO getBookById(@PathVariable Long id) throws BookNotFoundException{
        return libraryService.getBookById(id);
    }

    @GetMapping(value = "/get-books")
    public List<BookResponseDTO> getAllBooks(){
        return libraryService.getAllBooks();
    }

    @DeleteMapping(value = "/delete-book/{id}")
    public void deleteBookById(@PathVariable Long id) throws BookNotFoundException{
        libraryService.deleteBookById(id);
    }

    @PutMapping(value = "/update-book")
    public BookResponseDTO updateBookById(@Valid @RequestBody UpdateBookRequestDTO updateBookRequestDTO) throws BookNotFoundException, AuthorNotFoundException, CategoryNotFoundException{
        return libraryService.updateBookById(updateBookRequestDTO);
    }




    //BorrowedBooks method
    @PostMapping(value = "/save-borrowed-books")
    public void saveBorrowedBook(@Valid @RequestBody CreateBorrowedBookRequestDTO createBorrowedBookRequestDTO) throws MemberNotFoundException, BookNotFoundException{
        libraryService.saveBorrowedBook(createBorrowedBookRequestDTO);
    }

    @GetMapping(value = "/get-borrowed-books/{id}")
    public BorrowedBookResponseDTO getBorrowedBookById(@PathVariable Long id) throws BorrowBookNotFoundException{
        return libraryService.getBorrowedBookById(id);
    }

    @GetMapping(value = "/get-borrowed-books")
    public List<BorrowedBookResponseDTO> getBorrowedBook(){
        return libraryService.getBorrowedBook();
    }

    @DeleteMapping(value = "/delete-borrowed-books/{id}")
    public void deleteBorrowedBookById(@PathVariable Long id) throws BorrowBookNotFoundException{
        libraryService.deleteBorrowedBookById(id);
    }

    @PutMapping(value = "/update-borrowed-books")
    public BorrowedBookResponseDTO updateBorrowedBookById(@Valid @RequestBody UpdateBorrowedBookRequestDTO updateBorrowedBookRequestDTO) throws BorrowBookNotFoundException, MemberNotFoundException, BookNotFoundException{
        return libraryService.updateBorrowedBookById(updateBorrowedBookRequestDTO);
    }
}
