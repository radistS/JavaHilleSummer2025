package com.app.service;

import com.app.dto.ContactDto;
import com.app.dto.ContactRequest;
import java.util.List;
import java.util.UUID;

public interface ContactService {

    UUID createContact(ContactRequest contact);
    List<ContactDto> getAllContacts();
    ContactDto getContactById(UUID id);
    void updateContact(UUID id, ContactDto contact);
    void deleteContact(UUID id);

}
