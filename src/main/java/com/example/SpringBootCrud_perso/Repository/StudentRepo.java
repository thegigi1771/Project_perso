package com.example.SpringBootCrud_perso.Repository;

import com.example.SpringBootCrud_perso.Domain.Students; // 1) Pourquoi ??
import org.springframework.data.jpa.repository.JpaRepository; // 2)

public interface StudentRepo extends JpaRepository<Students, Long>{ // 1) 2)

}
