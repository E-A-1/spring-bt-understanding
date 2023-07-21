package com.example.springboot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Book;
import com.example.springboot.entity.Employee;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

}
