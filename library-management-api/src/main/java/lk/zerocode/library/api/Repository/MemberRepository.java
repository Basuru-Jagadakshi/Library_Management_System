package lk.zerocode.library.api.Repository;

import lk.zerocode.library.api.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
