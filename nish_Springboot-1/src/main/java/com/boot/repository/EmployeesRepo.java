package com.boot.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.boot.entity.Employees;



@Repository
public interface EmployeesRepo extends JpaRepository<Employees, Long>{

	
}
