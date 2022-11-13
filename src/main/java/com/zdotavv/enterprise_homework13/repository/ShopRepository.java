package com.zdotavv.enterprise_homework13.repository;

import com.zdotavv.enterprise_homework13.model.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {
}
