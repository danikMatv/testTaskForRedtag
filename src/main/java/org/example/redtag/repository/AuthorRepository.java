package org.example.redtag.repository;

import org.example.redtag.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    Author findAuthorByFirstNameAndLastName(String firstName,String lastName);


}
