package org.example.redtag.repository;

import org.example.redtag.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query(value = "SELECT c FROM Book c")
    List<Book> getAll();

    Book findBookByName(String name);
}
