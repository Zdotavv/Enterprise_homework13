package com.zdotavv.enterprise_homework13.repository;

import com.zdotavv.enterprise_homework13.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}
