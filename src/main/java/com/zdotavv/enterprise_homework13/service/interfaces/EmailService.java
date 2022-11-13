package com.zdotavv.enterprise_homework13.service.interfaces;

import com.zdotavv.enterprise_homework13.model.Cart;
import com.zdotavv.enterprise_homework13.model.Person;

public interface EmailService {

    void sendRegistrationEmail(Person person);
}