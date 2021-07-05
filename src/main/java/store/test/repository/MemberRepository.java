package store.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.test.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
}
