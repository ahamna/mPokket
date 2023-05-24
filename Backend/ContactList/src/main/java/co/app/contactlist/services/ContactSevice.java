package co.app.contactlist.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.app.contactlist.models.Contact;
import co.app.contactlist.repositores.ContactRepository;

@Service
public class ContactSevice {
	private ContactRepository contactRepository;
	
	public ContactSevice(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	public Contact createContact(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public Contact updateContact(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public Contact getContact(Long id) {
		return contactRepository.getReferenceById(id);
	}
	
	public List<Contact> getAllContact(){
		return contactRepository.findAll();
	}
	public Contact deleteContact(Long id) {
		Contact contact = contactRepository.getReferenceById(id);
		contactRepository.delete(contact);
		return contact;
	}
	
}	
