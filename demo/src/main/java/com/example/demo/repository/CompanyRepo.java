package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Company;

@Repository
public interface CompanyRepo extends CrudRepository<Company, Long>{

	@Query(value="insert into company (id, name, age,address) VALUES (:id, :name, :age,:address)", nativeQuery = true)
	void insertData(@Param("id") int id, @Param("name") String name,@Param("age") int age,@Param("address") String address);

	@Query(value="update company set age=:age where id=:id", nativeQuery = true)
    void updateData(@Param("age") int age,@Param("id") int id);

	@Query(value="from company", nativeQuery = true)
    void getData();

	@Query(value="delete from company where id=:id", nativeQuery = true)
    void deleteData(@Param("id") int id);

}
