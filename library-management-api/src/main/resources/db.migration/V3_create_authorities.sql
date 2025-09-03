-- 3. Create Authorities table
CREATE TABLE authorities (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             authority VARCHAR(100) NOT NULL,
                             member_id BIGINT,
                             CONSTRAINT fk_authority_member FOREIGN KEY (member_id)
                                 REFERENCES members(id) ON DELETE CASCADE
);