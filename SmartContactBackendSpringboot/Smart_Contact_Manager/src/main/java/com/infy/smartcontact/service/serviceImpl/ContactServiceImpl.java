package com.infy.smartcontact.service.serviceImpl;

import com.infy.smartcontact.model.Contact;
import com.infy.smartcontact.repository.ContactRepository;
import com.infy.smartcontact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;


    @Override
    public ResponseEntity<?> addContact(Contact contact) {
        Optional<Contact> contact1=contactRepository.findById(contact.getId());
        if(contact1.isPresent()){
        return ResponseEntity.badRequest().body("User Alread Exists");
        }
        Contact contact2=contactRepository.save(contact);
        return ResponseEntity.ok().body(contact2);
    }

    @Override
    public ResponseEntity<?> getAllContact() {
        return ResponseEntity.ok().body(contactRepository.findAll());
    }

    @Override
    public ResponseEntity<?> getContactById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if(contact.isPresent()){
            return ResponseEntity.ok().body(contact);
        }
        return ResponseEntity.badRequest().body("No user Found with this name");
    }

    @Override
    public ResponseEntity<?> updateContact(Contact contact) {
        Optional<Contact> contact1 = contactRepository.findById(contact.getId());
        if(contact1.isPresent()){
            Contact contact2= contactRepository.save(contact);
            return ResponseEntity.ok(contact2);
        }
        return ResponseEntity.badRequest().body("No User Found with UserId");
    }

    @Override
    public ResponseEntity<?> deleteContact(Long id) {
        contactRepository.deleteById(id);
        return ResponseEntity.ok("Scessfully Deleted");
    }
}
