package richardlab21g01project2.utils.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import richardlab21g01project2.utils.entities.*;


public interface ScrollRepository extends JpaRepository<Scroll, Long>, ScrollRepositoryCustom {
}


