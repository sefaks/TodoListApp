package com.sefaa.todoapplast.repository;


import com.sefaa.todoapplast.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {



}