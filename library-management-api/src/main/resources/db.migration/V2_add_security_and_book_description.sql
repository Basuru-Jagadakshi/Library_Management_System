ALTER TABLE members
    ADD COLUMN username VARCHAR(255) UNIQUE NOT NULL,
    ADD COLUMN password VARCHAR(255) NOT NULL,
    ADD COLUMN enabled BOOLEAN DEFAULT TRUE;

-- 2. Alter Books table: add description
ALTER TABLE books
    ADD COLUMN description TEXT;

-- 3. Create Authorities table
CREATE TABLE authorities (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             authority VARCHAR(100) NOT NULL,
                             member_id BIGINT,
                             CONSTRAINT fk_authority_member FOREIGN KEY (member_id)
                                 REFERENCES members(id) ON DELETE CASCADE
);