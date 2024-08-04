package org.example.redtag.repository;

import org.example.redtag.entity.Author;
import org.example.redtag.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query(value = "SELECT c FROM Book c")
    List<Book> getAll();

    @Modifying
    @Query(value = "DELETE FROM Book c WHERE c.name = :name")
    void deleteBookByName(@Param("name") String name);

    @Query(value = "SELECT c FROM Book c WHERE c.name = :name")
    Book findBookByName(@Param("name") String name);

    List<Book> getBooksByAuthor(Author author);
}
