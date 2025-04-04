package lk.zerocode.library.api.Service;

import lk.zerocode.library.api.DTO.Request.*;
import lk.zerocode.library.api.DTO.Response.*;
import lk.zerocode.library.api.Exceptions.*;
import lk.zerocode.library.api.Model.Author;

import java.util.List;
import java.util.Optional;

public interface LibraryService {

    //Author methods
    void saveAuthor(CreateAuthorRequestDTO createAuthorRequestDTO);

    AuthorResponseDTO getAuthorById(Long id) throws AuthorNotFoundException;

    List<AuthorResponseDTO> getAuthors();

    void deleteAuthor(Long id) throws AuthorNotFoundException;

    AuthorResponseDTO updateAuthor(UpdateAuthorRequestDTO updateAuthorRequestDTO) throws AuthorNotFoundException;



    //Category methods
    void saveCategory(CreateCategoryRequestDTO createCategoryRequestDTO);

    CategoryResponseDTO getCategoryById(Long id) throws CategoryNotFoundException;

    List<CategoryResponseDTO> getAllCategory();

    void deleteCategory(Long id) throws CategoryNotFoundException;

    CategoryResponseDTO updateCategory(UpdateCategoryRequestDTO updateCategoryRequestDTO) throws CategoryNotFoundException;



    //Member methods
    void saveMember(CreateMemberRequestDTO createMemberRequestDTO);

    MemberResponseDTO getMemberById(Long id) throws MemberNotFoundException;

    List<MemberResponseDTO> getMembers();

    void deleteMember(Long id) throws MemberNotFoundException;

    MemberResponseDTO updateMember(UpdateMemberRequestDTO updateMemberRequestDTO) throws MemberNotFoundException;




    //Book methods
    void saveBook(CreateBookRequestDTO createBookRequestDTO) throws AuthorNotFoundException, CategoryNotFoundException;

    BookResponseDTO getBookById(Long id) throws BookNotFoundException;

    List<BookResponseDTO> getAllBooks();

    void deleteBookById(Long id) throws BookNotFoundException;

    BookResponseDTO updateBookById(UpdateBookRequestDTO updateBookRequestDTO) throws BookNotFoundException, AuthorNotFoundException, CategoryNotFoundException;




    //BorrowedBook methods
    void saveBorrowedBook(CreateBorrowedBookRequestDTO createBorrowedBookRequestDTO) throws MemberNotFoundException, BookNotFoundException;

    BorrowedBookResponseDTO getBorrowedBookById(Long id) throws BorrowBookNotFoundException;

    List<BorrowedBookResponseDTO> getBorrowedBook();

    void deleteBorrowedBookById(Long id) throws BorrowBookNotFoundException;

    BorrowedBookResponseDTO updateBorrowedBookById(UpdateBorrowedBookRequestDTO updateBorrowedBookRequestDTO) throws BorrowBookNotFoundException, MemberNotFoundException, BookNotFoundException;
}
