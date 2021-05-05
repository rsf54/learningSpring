package com.hanselnpetal.controller;


import com.hanselnpetal.domain.CustomerContact;
import com.hanselnpetal.service.ContactsManagementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactsManagementController.class)
public class ContactsManagementControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactsManagementService contactsManagementService;

    @InjectMocks
    private ContactsManagementController contactsManagementController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void add_contact_happy_path() throws Exception{
        CustomerContact mockCustomerCantact = new CustomerContact();
        mockCustomerCantact.setFirstName("Fred");

        when(contactsManagementService.add(any(CustomerContact.class))).thenReturn(mockCustomerCantact);

        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Fred");
        aContact.setEmail("fredj@myemail.com");

        mockMvc.perform(post("/addContact", aContact)).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void add_contact_biz_service_rule_not_satisfied() throws Exception{
        when(contactsManagementService.add(any(CustomerContact.class))).thenReturn(null);

        CustomerContact aContact = new CustomerContact();
        aContact.setLastName("Johnson");

        mockMvc.perform(post("/addContact", aContact)).andExpect(status().is(302)).andReturn();

    }

    @Test
    public void add_contact_occasion_happy_path() throws Exception{
        //etc....
    }
}
