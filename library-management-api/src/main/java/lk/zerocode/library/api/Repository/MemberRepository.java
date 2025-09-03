package lk.zerocode.library.api.Repository;

import lk.zerocode.library.api.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUserName(String userName);
}
