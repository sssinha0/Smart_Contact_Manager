package com.infy.smartcontact.service;

import com.infy.smartcontact.model.Contact;
import org.springframework.http.ResponseEntity;

public interface ContactService {

    public ResponseEntity<?> addContact(Contact contact);
    public ResponseEntity<?> getAllContact();
    public ResponseEntity<?> getContactById(Long id);
    public ResponseEntity<?> updateContact(Contact contact);
    public ResponseEntity<?> deleteContact(Long id);
}
