package com.pensionerDetails.repositories;



import com.pensionerDetails.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailsRepository extends JpaRepository<User,Long> {

    public User findByUsername(String username);


}
