package co.app.contactlist.repositores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.app.contactlist.models.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
	@Query("SELECT l FROM Contact l WHERE l.lastName like CONCAT(:lastName, '%')")
    List<Contact> filterFeedbacks(@Param("lastName") String lastName);
}
