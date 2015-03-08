
package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.dto.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author helvinator
 */
public class ContactDaoDbImpl implements ContactDao {
    
    private static final String SQL_INSERT_CONTACT = 
            "insert into contacts (first_name, last_name, company, phone, email) values (?, ?, ?, ?, ?)";
    
    private static final String SQL_SELECT_ALL_CONTACTS = 
            "select * from contacts";
    
    private static final String SQL_DELETE_CONTACT=
            "delete from contacts where contact_id=?";
    
    private JdbcTemplate jdbcTemplate;
    
    // we're going to use XML driven setter injection so we can see how that works
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void addContact(Contact contact) {
        jdbcTemplate.update(SQL_INSERT_CONTACT,
                            contact.getFirstName(),
                            contact.getLastName(),
                            contact.getCompany(),
                            contact.getPhone(),
                            contact.getEmail());
        // now get the contactId value from the db and set it on the Contact
        contact.setContactId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public void removeContact(int contactId) {
jdbcTemplate.update(SQL_DELETE_CONTACT, contactId);
    }

    @Override
    public void updateContact(Contact contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> getAllContacts() {
        return jdbcTemplate.query(SQL_SELECT_ALL_CONTACTS, new ContactMapper());
    }

    @Override
    public Contact getContactById(int contactId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class ContactMapper implements ParameterizedRowMapper<Contact> {

        @Override
        public Contact mapRow(ResultSet rs, int i) throws SQLException {
            Contact contact = new Contact();
            contact.setContactId(rs.getInt("contact_id"));
            contact.setFirstName(rs.getString("first_name"));
            contact.setLastName(rs.getString("last_name"));
            contact.setCompany(rs.getString("company"));
            contact.setPhone(rs.getString("phone"));
            contact.setEmail(rs.getString("email"));
            return contact;
        }
        
    }

}
