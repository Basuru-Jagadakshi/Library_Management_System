package lk.zerocode.library.api.Repository;

import lk.zerocode.library.api.Model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
