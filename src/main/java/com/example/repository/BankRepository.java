package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Bank;


public interface BankRepository extends CrudRepository<Bank, Integer> {

	Optional<Bank> findByBranch(String branch);

	Optional<Bank> findByNameAndPassbook(String name, String passbook);

	List<Bank> findByPassbookOrBranch(String passbook, String branch);

	boolean existsBypassbook(String passbook);

	boolean existsByName(String name);

	@Query("select e from Bank e where e.name=:name")
	Bank findbyNameQuery(@Param("name") String name);

	@Query("Select e from Bank e where e.branch=:branch and e.name=:name")
	Bank findByBranchAndNameQuery(@Param("branch") String branch, @Param("name") String name);

	@Query("Select e from Bank e where e.name=:name or e.passbook=:passbook")
	List<Bank> findByNameOrPassbookQuery(@Param("name") String name, @Param("passbook") String passbook);

}
