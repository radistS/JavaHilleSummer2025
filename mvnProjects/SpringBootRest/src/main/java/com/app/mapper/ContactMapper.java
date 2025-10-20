package com.app.mapper;

import com.app.dto.ContactDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import org.springframework.jdbc.core.RowMapper;

public class ContactMapper implements RowMapper<ContactDto> {

    @Override
    public ContactDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ContactDto contactDto = new ContactDto();

        contactDto.setId(UUID.fromString(rs.getString("id")));
        contactDto.setFirstName(rs.getString("first_name"));
        contactDto.setLastName(rs.getString("last_name"));
        contactDto.setEmail(rs.getString("email"));
        contactDto.setPhone(rs.getString("phone"));
        return contactDto;
    }
}
