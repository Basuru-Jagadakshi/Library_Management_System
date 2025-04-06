package lk.zerocode.library.api.Service.Impl;

import lk.zerocode.library.api.DTO.Request.*;
import lk.zerocode.library.api.DTO.Response.*;
import lk.zerocode.library.api.Exceptions.*;
import lk.zerocode.library.api.Model.*;
import lk.zerocode.library.api.Repository.*;
import lk.zerocode.library.api.Service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImpl implements LibraryService {

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


    Logger log = LoggerFactory.getLogger(LibraryServiceImpl.class);


    //Author methods
    @Override
    public void saveAuthor(CreateAuthorRequestDTO createAuthorRequestDTO) {
        Author author = new Author();

        author.setAuthorName(createAuthorRequestDTO.getAuthorName());
        author.setAuthorBio(createAuthorRequestDTO.getBio());

        authorRepository.save(author);
    }

    @Override
    public AuthorResponseDTO getAuthorById(Long id) throws AuthorNotFoundException {
        Optional<Author> authorOptional = authorRepository.findById(id);

        if(authorOptional.isPresent()){
            Author author = authorOptional.get();
            return new AuthorResponseDTO(author.getAuthorName(), author.getAuthorBio());
        }
        else {
            throw new AuthorNotFoundException();
        }
    }

    @Override
    public List<AuthorResponseDTO> getAuthors() {
        return authorRepository.findAll().stream()
                .map(author -> new AuthorResponseDTO(author.getAuthorName(), author.getAuthorBio()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAuthor(Long id) throws AuthorNotFoundException{
        if(authorRepository.existsById(id)){
            authorRepository.deleteById(id);
        }
        else {
            throw new AuthorNotFoundException();
        }
    }

    @Override
    public AuthorResponseDTO updateAuthor(UpdateAuthorRequestDTO updateAuthorRequestDTO) throws AuthorNotFoundException{
        Optional<Author> authorOptional = authorRepository.findById(updateAuthorRequestDTO.getId());

        if(authorOptional.isPresent()){
            Author author = authorOptional.get();

            author.setAuthorName(updateAuthorRequestDTO.getAuthorName());
            author.setAuthorBio(updateAuthorRequestDTO.getBio());

            authorRepository.save(author);

            return new AuthorResponseDTO(author.getAuthorName(), author.getAuthorBio());
        }
        else {
            throw new AuthorNotFoundException();
        }
    }





    //Category methods
    @Override
    public void saveCategory(CreateCategoryRequestDTO createCategoryRequestDTO) {
        Category category = new Category();

        category.setCategoryName(createCategoryRequestDTO.getCategoryName());
        category.setDescription(createCategoryRequestDTO.getDescription());

        categoryRepository.save(category);
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) throws CategoryNotFoundException {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if(categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            return new CategoryResponseDTO(category.getCategoryName(),
                    category.getDescription());
        }
        else {
            throw new CategoryNotFoundException();
        }
    }

    @Override
    public List<CategoryResponseDTO> getAllCategory() {
        return categoryRepository.findAll().stream().
                map(category -> new CategoryResponseDTO(category.getCategoryName(), category.getDescription())).
                collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Long id) throws CategoryNotFoundException {
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        }
        else {
            throw new CategoryNotFoundException();
        }
    }

    @Override
    public CategoryResponseDTO updateCategory(UpdateCategoryRequestDTO updateCategoryRequestDTO) throws CategoryNotFoundException {
        Optional<Category> categoryOptional = categoryRepository.findById(updateCategoryRequestDTO.getId());

        if (categoryOptional.isPresent()){
            Category category = categoryOptional.get();

            category.setCategoryName(updateCategoryRequestDTO.getCategoryName());
            category.setDescription(updateCategoryRequestDTO.getDescription());

            categoryRepository.save(category);

            return new CategoryResponseDTO(category.getCategoryName(), category.getDescription());
        }
        else {
            throw new CategoryNotFoundException();
        }
    }



    //Member methods
    public void saveMember(CreateMemberRequestDTO createMemberRequestDTO){
        Member member = new Member();

        member.setMemberName(createMemberRequestDTO.getMemberName());
        member.setEmail(createMemberRequestDTO.getEmail());

        memberRepository.save(member);
    }

    public MemberResponseDTO getMemberById(Long id) throws MemberNotFoundException{
        Optional<Member> memberOptional = memberRepository.findById(id);

        if (memberOptional.isPresent()){
            Member member = memberOptional.get();

            return new MemberResponseDTO(member.getMemberName(), member.getEmail());
        }
        else {
            throw new MemberNotFoundException();
        }
    }

    @Override
    public List<MemberResponseDTO> getMembers() {
        return memberRepository.findAll().stream().
                map(member -> new MemberResponseDTO(member.getMemberName(), member.getEmail())).
                collect(Collectors.toList());
    }

    public void deleteMember(Long id) throws MemberNotFoundException{
        if (memberRepository.existsById(id)){
            memberRepository.deleteById(id);
        }
        else{
            throw new MemberNotFoundException();
        }
    }

    @Override
    public MemberResponseDTO updateMember(UpdateMemberRequestDTO updateMemberRequestDTO) throws MemberNotFoundException {
        Optional<Member> memberOptional = memberRepository.findById(updateMemberRequestDTO.getId());

        if (memberOptional.isPresent()){
            Member member = memberOptional.get();

            member.setMemberName(updateMemberRequestDTO.getMemberName());
            member.setEmail(updateMemberRequestDTO.getEmail());

            memberRepository.save(member);

            return new MemberResponseDTO(member.getMemberName(), member.getEmail());
        }
        else {
            throw new MemberNotFoundException();
        }
    }




    //Book methods
    @Override
    public void saveBook(CreateBookRequestDTO createBookRequestDTO) throws AuthorNotFoundException, CategoryNotFoundException {
        Book book = new Book();

        book.setTitle(createBookRequestDTO.getTitle());
        book.setIsbn(createBookRequestDTO.getIsbn());
        book.setPublishedYear(createBookRequestDTO.getPublishedYear());
        book.setTotalCopies(createBookRequestDTO.getTotalCopies());
        book.setAvailableCopies(createBookRequestDTO.getAvailableCopies());

        Optional<Author> authorOptional = authorRepository.findById(createBookRequestDTO.getAuthorId());
        Optional<Category> categoryOptional = categoryRepository.findById(createBookRequestDTO.getCategoryId());

        if (!authorOptional.isPresent()){
            throw new AuthorNotFoundException();
        } else if (!categoryOptional.isPresent()) {
            throw new CategoryNotFoundException();
        }
        else {
            book.setAuthor(authorOptional.get());
            book.setCategory(categoryOptional.get());
        }

        bookRepository.save(book);
    }

    @Override
    public BookResponseDTO getBookById(Long id) throws BookNotFoundException {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()){
            Book book = bookOptional.get();

            return new BookResponseDTO(book.getTitle(),
                    book.getIsbn(),
                    book.getPublishedYear(),
                    book.getTotalCopies(),
                    book.getAvailableCopies(),
                    book.getAuthor(),
                    book.getCategory());
        }
        else
            throw new BookNotFoundException();
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        return bookRepository.findAll().stream().
                map(book -> new BookResponseDTO(book.getTitle(),
                        book.getIsbn(),
                        book.getPublishedYear(),
                        book.getTotalCopies(),
                        book.getAvailableCopies(),
                        book.getAuthor(),
                        book.getCategory())).collect(Collectors.toList());
    }

    @Override
    public void deleteBookById(Long id) throws BookNotFoundException {
        if (bookRepository.existsById(id))
            bookRepository.deleteById(id);
        else
            throw new BookNotFoundException();
    }

    @Override
    public BookResponseDTO updateBookById(UpdateBookRequestDTO updateBookRequestDTO) throws BookNotFoundException, AuthorNotFoundException, CategoryNotFoundException {
        Optional<Book> bookOptional = bookRepository.findById(updateBookRequestDTO.getId());

        if(bookOptional.isPresent()){
            Book book = bookOptional.get();

            book.setTitle(updateBookRequestDTO.getTitle());
            book.setIsbn(updateBookRequestDTO.getIsbn());
            book.setPublishedYear(updateBookRequestDTO.getPublishedYear());
            book.setTotalCopies(updateBookRequestDTO.getTotalCopies());
            book.setAvailableCopies(updateBookRequestDTO.getAvailableCopies());

            Optional<Author> authorOptional = authorRepository.findById(updateBookRequestDTO.getAuthorId());
            Optional<Category> categoryOptional = categoryRepository.findById(updateBookRequestDTO.getCategoryId());

            if (!authorOptional.isPresent()){
                throw new AuthorNotFoundException();
            } else if (!categoryOptional.isPresent()) {
                throw new CategoryNotFoundException();
            }
            else {
                book.setAuthor(authorOptional.get());
                book.setCategory(categoryOptional.get());
            }

            bookRepository.save(book);

            return new BookResponseDTO(book.getTitle(),
                    book.getIsbn(),
                    book.getPublishedYear(),
                    book.getTotalCopies(),
                    book.getAvailableCopies(),
                    book.getAuthor(),
                    book.getCategory());
        }
        else
            throw new BookNotFoundException();
    }





    //BorrowedBook methods
    @Transactional
    @Override
    public void saveBorrowedBook(CreateBorrowedBookRequestDTO createBorrowedBookRequestDTO) throws MemberNotFoundException, BookNotFoundException {
        BorrowBook borrowBook = new BorrowBook();

        Optional<Member> memberOptional = memberRepository.findById(createBorrowedBookRequestDTO.getMemberId());
        Optional<Book> bookOptional = bookRepository.findById(createBorrowedBookRequestDTO.getBookId());

        if(!memberOptional.isPresent()){
            throw new MemberNotFoundException();
        } else if (!bookOptional.isPresent()) {
            throw new BookNotFoundException();
        }
        else{
            borrowBook.setMember(memberOptional.get());
            borrowBook.setBook(bookOptional.get());
            deductAvailableBooks(bookOptional.get());
            log.info("Successfully deduct number of available books by one.");
        }

        borrowBookRepository.save(borrowBook);
    }

    @Override
    public BorrowedBookResponseDTO getBorrowedBookById(Long id) throws BorrowBookNotFoundException {
        BorrowBook borrowBookOptional = borrowBookRepository.findById(id).orElseThrow(() ->new BorrowBookNotFoundException());

        return new BorrowedBookResponseDTO(borrowBookOptional.getMember().getId(),
                borrowBookOptional.getBook().getId(),
                borrowBookOptional.getStatus(),
                borrowBookOptional.getBorrowedDate(),
                borrowBookOptional.getDueDate());
    }

    @Override
    public List<BorrowedBookResponseDTO> getBorrowedBook() {
        return borrowBookRepository.findAll().stream().
                map(borrowBook -> new BorrowedBookResponseDTO(borrowBook.getMember().getId(),
                        borrowBook.getBook().getId(),
                        borrowBook.getStatus(),
                        borrowBook.getBorrowedDate(),
                        borrowBook.getDueDate())).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteBorrowedBookById(Long id) throws BorrowBookNotFoundException {
        if (borrowBookRepository.existsById(id)){
            addAvailableBooks(bookRepository.findById(borrowBookRepository.findById(id).get().getBook().getId()).get());
            log.info("Successfully add number of available books by one.");
            borrowBookRepository.deleteById(id);
        }
        else
            throw new BorrowBookNotFoundException();
    }

    @Override
    public BorrowedBookResponseDTO updateBorrowedBookById(UpdateBorrowedBookRequestDTO updateBorrowedBookRequestDTO) throws BorrowBookNotFoundException, MemberNotFoundException, BookNotFoundException {
        BorrowBook borrowBook = borrowBookRepository.findById(updateBorrowedBookRequestDTO.getId()).orElseThrow(()->new BorrowBookNotFoundException());

        Member member = memberRepository.findById(updateBorrowedBookRequestDTO.getMemberId()).orElseThrow(() -> new MemberNotFoundException());
        Book book = bookRepository.findById(updateBorrowedBookRequestDTO.getBookId()).orElseThrow(() -> new BookNotFoundException());

        borrowBook.setMember(member);
        borrowBook.setBook(book);

        borrowBookRepository.save(borrowBook);

        return new BorrowedBookResponseDTO(borrowBook.getMember().getId(),
                borrowBook.getBook().getId(),
                borrowBook.getStatus(),
                borrowBook.getBorrowedDate(),
                borrowBook.getDueDate());
    }













    //deduct number of available books
    private void deductAvailableBooks(Book book){
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);
    }


    //add number of available books
    private void addAvailableBooks(Book book){
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);
    }
}
