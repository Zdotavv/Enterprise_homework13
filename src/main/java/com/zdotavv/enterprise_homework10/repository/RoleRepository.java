package com.zdotavv.enterprise_homework10.repository;

import com.zdotavv.enterprise_homework10.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findRoleByName(String name);

}
