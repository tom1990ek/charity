package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entity.Institution;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    List<Institution> findAll();
}
