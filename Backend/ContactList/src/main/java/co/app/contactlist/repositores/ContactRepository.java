package co.app.contactlist.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.app.contactlist.models.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

}
