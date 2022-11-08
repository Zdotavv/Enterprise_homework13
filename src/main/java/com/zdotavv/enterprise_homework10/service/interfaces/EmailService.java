package com.zdotavv.enterprise_homework10.service.interfaces;

import com.zdotavv.enterprise_homework10.model.Cart;
import com.zdotavv.enterprise_homework10.model.Person;

public interface EmailService {

    void sendRegistrationEmail(Person person);
}