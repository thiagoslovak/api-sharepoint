package br.com.eive.apisharepoint.repository;

import br.com.eive.apisharepoint.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

    List<CustomerModel> findByOrderById();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "update customer set db_info = :db_info," +
            "name = :name," +
            "notes = :notes," +
            "responsible = :responsible," +
            "segment = :segment," +
            "tier = :tier," +
            "use_vpn = false," +
            "uses_new_integration = false where id = :id")
    void updateId(@Param("db_info") String dbInfo, @Param("name") String name, @Param("notes") String notes,
                         @Param("responsible") String responsible, @Param("segment") String segment, @Param("tier") Character tier,
                         @Param("id") Long id);
}
