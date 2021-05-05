package com.hanselnpetal.service;

import com.hanselnpetal.data.repos.CustomerContactRepository;
import com.hanselnpetal.domain.CustomerContact;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ContactsManagementServiceUnitTest {

    @Mock
    private CustomerContactRepository customerContactRepository;

    @InjectMocks
    private ContactsManagementService contactsManagementService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void add_contact_happy_path(){

        // Create a contact
        CustomerContact aMockContact = new CustomerContact();
        aMockContact.setFirstName("Jenny");
        aMockContact.setLastName("Johnson");

        when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(aMockContact);

        // Save the contact
        CustomerContact newContact = contactsManagementService.add(null);

        //Verify the save
        assertEquals("Jenny", newContact.getFirstName());
    }
}
