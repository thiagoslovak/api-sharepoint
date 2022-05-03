package br.com.eive.apisharepoint.repository;

import br.com.eive.apisharepoint.model.ServerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ServerRepository extends JpaRepository<ServerModel, Long> {

    List<ServerModel> findByOrderById();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "update server set ip = :ip," +
            "dns = :dns," +
            "login = :login," +
            "password = :password," +
            "name = :name," +
            "notes = :notes where id = :id")
    void updateId(@Param("ip") String ip, @Param("dns") String dns, @Param("login") String login,
                  @Param("password") String password, @Param("name") String name, @Param("notes") String notes, @Param("id") Long id);
}
