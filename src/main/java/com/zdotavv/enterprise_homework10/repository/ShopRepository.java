package com.zdotavv.enterprise_homework10.repository;

import com.zdotavv.enterprise_homework10.model.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {
}
