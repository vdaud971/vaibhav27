package com.example;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Bank;
import com.example.repository.BankRepository;

@SpringBootTest
class BankApplicationTests {

	@Autowired
	private BankRepository bankRepository;
	@Test
	void addBankDetails() {
		Bank bank = new Bank();
		bank.setPassbook("yes");
		bank.setAccount_number("54224900333");
		bank.setName("kaushal");
		bank.setBranch("BOB");
		bankRepository.save(bank);
	}
	@Test
	 void ByDelete() {
		bankRepository.deleteById(1);
	}
	
	@Test
	void findByName() {
		Optional<Bank> findbyName = bankRepository.findByBranch("SBI");
		if(findbyName.isPresent()) {
			 Bank bank = findbyName.get();
			System.out.println(bank.getAccount_number());
			System.out.println(bank.getBranch());
			System.out.println(bank.getPassbook());
			System.out.println(bank.getBank_Id());
			System.out.println(bank.getName());
		}else {
			System.out.println("Null_Pointer");
		}
	}
	@Test 
	void findByNameAndPassbook(){
		Optional<Bank> byNameAndPassbook = bankRepository.findByNameAndPassbook("rohit", "no");
		if(byNameAndPassbook.isPresent()) {
			Bank bank = byNameAndPassbook.get();
			System.out.println(bank.getAccount_number());
			System.out.println(bank.getBranch());
			System.out.println(bank.getPassbook());
			System.out.println(bank.getBank_Id());
			System.out.println(bank.getName());
		}else {
			System.out.println("Null_Pointer");
		}
		
	}
	@Test
	void findByPassbookOrBank() {
		List<Bank> byPassbookOrBank = bankRepository.findByPassbookOrBranch("no", "BOB");
		for (Bank bank : byPassbookOrBank) {
			System.out.println(bank.getAccount_number());
			System.out.println(bank.getBranch());
			System.out.println(bank.getPassbook());
			System.out.println(bank.getBank_Id());
			System.out.println(bank.getName());
		}
	}
	@Test
	void findByPassbook() {
		boolean val = bankRepository.existsBypassbook("yes");
		System.out.println(val);
	}
	@Test 
	void findByNameb(){
		boolean existsByName = bankRepository.existsByName("vaibhav");
		System.out.println(existsByName);
	}
	@Test
	void findByNameQuery() {
		Bank findbyNameQuery = bankRepository.findbyNameQuery("rohit");
		System.out.println(findbyNameQuery.getBranch());
		System.out.println(findbyNameQuery.getBank_Id());
		System.out.println(findbyNameQuery.getAccount_number());
	}
	@Test
	void findByNameAndBranchQuery() {
		Bank byBranchAndNameQuery = bankRepository.findByBranchAndNameQuery("ICICI","rohit");
		System.out.println(byBranchAndNameQuery.getPassbook());
		System.out.println(byBranchAndNameQuery.getBank_Id());
		System.out.println(byBranchAndNameQuery.getAccount_number());
	}
	@Test
	void findByNameOrPassbook() {
		 List<Bank> byNameOrPassbookQuery =  bankRepository.findByNameOrPassbookQuery("kaushal","no");
		for (Bank object : byNameOrPassbookQuery) {
			System.out.println(object.getAccount_number());
			System.out.println(object.getBank_Id());
			System.out.println(object.getBranch());
		}
	}
}
