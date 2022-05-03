package br.com.eive.apisharepoint.repository;

import br.com.eive.apisharepoint.model.ContactModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactModel, Long> {

    List<ContactModel> findByOrderById();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "update contact set name = :name," +
            "email = :email," +
            "phone = :phone," +
            "cellphone = :cellphone," +
            "main = false where id = :id")
    void updateId(@Param("name") String name, @Param("email") String email, @Param("phone") String phone,
                  @Param("cellphone") String cellphone, @Param("id") Long id);
}
