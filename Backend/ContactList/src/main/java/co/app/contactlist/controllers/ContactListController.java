package co.app.contactlist.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.app.contactlist.models.Contact;
import co.app.contactlist.services.ContactSevice;

@RestController
@RequestMapping("/contact")
public class ContactListController {
	ContactSevice contactService;
	public ContactListController(ContactSevice contactService) {
		this.contactService = contactService;
	}
	@GetMapping(path = "/")
	ResponseEntity<List<Contact>> getAllContact(){
		List<Contact> contacts = contactService.getAllContact();
		if(contacts.size()  == 0) {
			return new ResponseEntity<List<Contact>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
		}
	}
	@GetMapping(path = "/{id}")
	ResponseEntity<Contact> getContact(@PathVariable Long id){
		Contact contact;
		try {
			contact = contactService.getContact(id);
		} catch (Exception e) {
			return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
		
	}
	
	@PostMapping
	ResponseEntity<Contact> createContact(Contact contact){
		Contact createdContact = contactService.createContact(contact);
		if(createdContact == null) {
			return new ResponseEntity<Contact>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Contact>(createdContact, HttpStatus.OK);
		}
	}
	
	@PutMapping
	ResponseEntity<Contact> updateContact(Contact contact){
		Contact updatedContact = contactService.updateContact(contact);
		return new ResponseEntity<Contact>(updatedContact, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Contact> deleteContact(@PathVariable Long id){
		Contact contact = contactService.deleteContact(id);
		if(contact == null) {
			return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Contact>(contact, HttpStatus.OK);
		}
	}
}
