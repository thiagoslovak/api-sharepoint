package br.com.eive.apisharepoint.repository;

import br.com.eive.apisharepoint.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    List<ProductModel> findByOrderById();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "update product set name = :name," +
            "notes = :notes," +
            "acquisition_date = :acquisitionDate where id = :id")
    void updateId(@Param("name") String name, @Param("notes") String notes,
                  @Param("acquisitionDate") String acquisitionDate, @Param("id") Long id);
}
