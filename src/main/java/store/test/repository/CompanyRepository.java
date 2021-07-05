package store.test.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.test.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
