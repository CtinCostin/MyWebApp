package com.george.MyWebApp.repo;

import com.george.MyWebApp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public Long countById(Long id);
}
