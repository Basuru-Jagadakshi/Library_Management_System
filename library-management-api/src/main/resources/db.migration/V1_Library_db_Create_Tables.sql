-- Create Authors Table
CREATE TABLE authors (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         author_name VARCHAR(255),
                         author_bio TEXT
);

-- Create Categories Table
CREATE TABLE categories (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            category_name VARCHAR(255),
                            category_description TEXT
);

-- Create Members Table
CREATE TABLE members (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         member_name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) UNIQUE NOT NULL
);

-- Create Books Table
CREATE TABLE books (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       book_title VARCHAR(255),
                       book_isbn VARCHAR(50) UNIQUE,
                       published_date VARCHAR(20),
                       total_copies INT,
                       available_copies INT,
                       author_id BIGINT,
                       category_id BIGINT,
                       FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE SET NULL,
                       FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE SET NULL
);

-- Create Borrowed Books Table
CREATE TABLE borrowed_books (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                status VARCHAR(50) DEFAULT 'Borrowed',
                                borrowed_date DATE NOT NULL,
                                due_date DATE NOT NULL,
                                member_id BIGINT,
                                book_id BIGINT,
                                FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE CASCADE,
                                FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE
);
