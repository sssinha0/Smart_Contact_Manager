package com.infy.smartcontact.repository;

import com.infy.smartcontact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
