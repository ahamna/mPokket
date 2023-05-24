package co.app.contactlist.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.app.contactlist.exceptions.ContactNotFound;
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
	
	public Contact updateContact(Contact contact) throws ContactNotFound {
		Contact currentContact = contactRepository.findById(contact.getId()).orElseThrow(() -> new ContactNotFound("Contact with id: "+contact.getId()+" Not Found"));
		currentContact.setFirstName(contact.getFirstName());
		currentContact.setLastName(contact.getLastName());
		currentContact.setPhone(contact.getPhone());
		return contactRepository.save(currentContact);
	}
	
	public Contact getContact(Long id) throws ContactNotFound {
		return contactRepository.findById(id).orElseThrow(() -> new ContactNotFound("Contact with id: "+id+" Not Found"));
	}
	
	public List<Contact> getAllContact(){
		return contactRepository.findAll();
	}
	public Contact deleteContact(Long id) throws ContactNotFound {
		Contact contact = contactRepository.findById(id).orElseThrow(() -> new ContactNotFound("Contact with id: "+id+" Not Found"));
		contactRepository.delete(contact);
		return contact;
	}

	public List<Contact> filteredByLastName(String lastName) {
		return contactRepository.filterFeedbacks(lastName);
	}
	
}	
