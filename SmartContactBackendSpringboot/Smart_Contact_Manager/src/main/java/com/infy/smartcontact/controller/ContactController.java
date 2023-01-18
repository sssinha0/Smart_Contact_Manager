package com.infy.smartcontact.controller;

import com.infy.smartcontact.model.Contact;
import com.infy.smartcontact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;
    @PostMapping("/add")
    public ResponseEntity<?> addContact(@RequestBody Contact contact){
        return contactService.addContact(contact);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllContact(){
        return  contactService.getAllContact();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getContactById(@PathVariable("id") Long id){
        return  contactService.getContactById(id);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateContact(@RequestBody Contact contact){
        return contactService.updateContact(contact);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id")Long id){
        return contactService.deleteContact(id);
    }
}
