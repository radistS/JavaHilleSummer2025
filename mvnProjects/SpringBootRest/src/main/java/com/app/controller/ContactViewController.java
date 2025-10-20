package com.app.controller;

import com.app.dto.ContactDto;
import com.app.dto.ContactRequest;
import com.app.service.ContactService;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/contacts")
@RequiredArgsConstructor
public class ContactViewController {

    private final ContactService contactService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("contacts", contactService.getAllContacts());
        return "contacts/list";
    }

    @GetMapping("/")
    public String home() { return "redirect:/ui/contacts"; }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("contact", new ContactDto());
        model.addAttribute("mode", "create");
        return "contacts/form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("contact") ContactRequest contact,
        BindingResult binding) {
        if (binding.hasErrors()) return "contacts/form";
        contactService.createContact(contact);
        return "redirect:/ui/contacts";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable UUID id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id));
        model.addAttribute("mode", "edit");
        return "contacts/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable UUID id,
        @Valid @ModelAttribute("contact") ContactDto contact,
        BindingResult binding) {
        if (binding.hasErrors()) return "contacts/form";
        contactService.updateContact(id, contact);
        return "redirect:/ui/contacts";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable UUID id) {
        contactService.deleteContact(id);
        return "redirect:/ui/contacts";
    }
}

