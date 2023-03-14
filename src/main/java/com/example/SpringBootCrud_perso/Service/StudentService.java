package com.example.SpringBootCrud_perso.Service;

import com.example.SpringBootCrud_perso.Repository.StudentRepo; // 1)
import org.springframework.beans.factory.annotation.Autowired; // 2) ????
import com.example.SpringBootCrud_perso.Domain.Students; // 3)
import org.springframework.stereotype.Service;

import java.util.List;
// je ne comprends pas l'utiliter des fonctions

@Service
public class StudentService {
    @Autowired // 2) ????
    private StudentRepo repo; // 1)
    public void save (Students students) {
        repo.save(students);
    } // 3)
    public List<Students> findAll () {
        return repo.findAll();
    }

    public void delete (Long id) {repo.deleteById(id);} // pourquoi Long et pas String ??

    public Students findById (Long id) {return repo.findById(id).orElse(null);} // JE COMPRENDS PAS

    public Long generateNewId () {
        if (findAll().size() == 0) {
            return 1L;
        }
        else {
            return findAll().get(findAll().size() - 1).getId() + 1;
        }
    }
}
