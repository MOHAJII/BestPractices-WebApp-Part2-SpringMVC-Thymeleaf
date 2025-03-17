package net.haji.springmvcthymeleaf.dao.repositories;

import net.haji.springmvcthymeleaf.dao.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNameContains(String nom);

    @Query("select p from Patient p where p.name like :x")
    List<Patient> search(@Param("x") String mc);
}
