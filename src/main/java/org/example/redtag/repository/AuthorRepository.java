package org.example.redtag.repository;

import org.example.redtag.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Book,Integer> {
}
