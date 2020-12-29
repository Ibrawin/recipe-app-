package ibrawin.springframwork.spring5receipeapp.repositories;

import ibrawin.springframwork.spring5receipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String Description);
}
