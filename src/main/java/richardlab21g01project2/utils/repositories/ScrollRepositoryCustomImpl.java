package richardlab21g01project2.utils.repositories;
import java.util.List;
import richardlab21g01project2.utils.entities.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;


@Repository
public class ScrollRepositoryCustomImpl implements ScrollRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Scroll> findAllScrolls() {
        Query query = entityManager.createNativeQuery("SELECT * FROM scroll", Scroll.class);
        List<Scroll> scrolls = query.getResultList();
        for (Scroll scroll : scrolls) {
            byte[] blobData = (byte[]) entityManager.createNativeQuery("SELECT binary_file_data FROM scroll WHERE scroll_id = :id")
                    .setParameter("id", scroll.getScrollId())
                    .getSingleResult();
            scroll.setBinaryFileData(blobData);
        }
        return scrolls;
    }
}



