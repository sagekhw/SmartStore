package store.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import store.test.entity.Company;
import store.test.entity.Member;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email);

    @Query(value = "SELECT m.company_id, m.id, m.email, m.mobile_phone_number, m.username, c.name \n" +
            "FROM member m join company c \n" +
            "WHERE c.id = :id",nativeQuery = true)
    List<Member> findByCompanyIn(@Param("id") Long id);
}
