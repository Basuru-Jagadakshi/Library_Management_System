package lk.zerocode.library.api.Repository;

import lk.zerocode.library.api.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
