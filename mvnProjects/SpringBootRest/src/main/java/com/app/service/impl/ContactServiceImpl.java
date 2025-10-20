package com.app.service.impl;

import com.app.dto.ContactDto;
import com.app.dto.ContactRequest;
import com.app.mapper.ContactMapper;
import com.app.mapper.OdjMapper;
import com.app.service.ContactService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final JdbcTemplate jdbcTemplate; // statement
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;  // preparedStatement
    private final OdjMapper odjMapper;

    @Override
    public UUID createContact(ContactRequest contact) {
        ContactDto contactDto = odjMapper.mapContactDto(contact);
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
            .addValue("id", contactDto.getId().toString())
            .addValue("firstName", contactDto.getFirstName())
            .addValue("lastName", contactDto.getLastName())
            .addValue("phone", contactDto.getPhone())
            .addValue("email", contactDto.getEmail());

        String sql = """
            INSERT INTO contact (id, first_name, last_name, phone, email)
            VALUES (:id, :firstName, :lastName, :phone, :email)
            """;

        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
        return contactDto.getId();
    }

    @Override
    public List<ContactDto> getAllContacts() {
        String sql = "select * from contact";
        return jdbcTemplate.query(sql, new ContactMapper());
    }

    @Override
    public ContactDto getContactById(UUID id) {
        String sql = "select * from contact where id = ?";
        return jdbcTemplate.queryForObject(sql, new ContactMapper(), id.toString());
    }

    @Override
    public void updateContact(UUID id, ContactDto contact) {
        StringBuilder sql = new StringBuilder("UPDATE contact SET ");
        MapSqlParameterSource params = new MapSqlParameterSource();

        if (contact.getFirstName() != null) {
            sql.append("first_name = :firstName, ");
            params.addValue("firstName", contact.getFirstName());
        }
        if (contact.getLastName() != null) {
            sql.append("last_name = :lastName, ");
            params.addValue("lastName", contact.getLastName());
        }
        if (contact.getPhone() != null) {
            sql.append("phone = :phone, ");
            params.addValue("phone", contact.getPhone());
        }
        if (contact.getEmail() != null) {
            sql.append("email = :email, ");
            params.addValue("email", contact.getEmail());
        }

        // Remove the last comma and space
        sql.setLength(sql.length() - 2);

        sql.append(" WHERE id = :id");
        params.addValue("id", id.toString());

        namedParameterJdbcTemplate.update(sql.toString(), params);
    }

    @Override
    public void deleteContact(UUID id) {
        String sql = "delete from contact where id = ?";
        jdbcTemplate.update(sql, id.toString());
    }
}
