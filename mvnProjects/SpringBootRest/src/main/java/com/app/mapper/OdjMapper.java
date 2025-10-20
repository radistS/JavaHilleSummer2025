package com.app.mapper;

import com.app.dto.ContactDto;
import com.app.dto.ContactRequest;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class OdjMapper {
    public  ContactDto mapContactDto(ContactRequest contact) {
        ContactDto contactDto = new ContactDto();
        contactDto.setId(UUID.randomUUID());
        contactDto.setFirstName(contact.getFirstName());
        contactDto.setLastName(contact.getLastName());
        contactDto.setPhone(contact.getPhone());
        contactDto.setEmail(contact.getEmail());
        return contactDto;

    }
}
