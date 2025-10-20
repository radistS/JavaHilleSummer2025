package com.app.controller;

import com.app.dto.ContactDto;
import com.app.dto.ContactRequest;
import com.app.service.ContactService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1/contact")
@RequiredArgsConstructor
@Slf4j
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public UUID createContact(@Valid @RequestBody ContactRequest contact) {
        return contactService.createContact(contact);
    }

    @GetMapping
    public List<ContactDto> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ContactDto getContactById(@PathVariable UUID id) {
        return contactService.getContactById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteContactById(@PathVariable UUID id) {
        contactService.deleteContact(id);
    }

    @DeleteMapping
    public void deleteContactByIdRP (@RequestParam UUID id) {
        contactService.deleteContact(id);
    }

    @PutMapping("/{id}")
    public void updateContact(
        @PathVariable UUID id,
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String lastName,
        @RequestParam(required = false) String email,
        @RequestParam(required = false) String phone) {
        ContactDto contactDto = new ContactDto()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(email)
            .setPhone(phone);

        contactService.updateContact(id, contactDto);
    }
}
