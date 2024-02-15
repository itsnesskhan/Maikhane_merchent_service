package com.maikhane.mercentservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maikhane.mercentservice.entity.Role;
import com.maikhane.mercentservice.repository.RoleRepository;


@SpringBootApplication
public class MarchentServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MarchentServiceApplication.class, args);
	}
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Role ownerRole = Role.builder().roleType("OWNER").build();
		Role managerRole = Role.builder().roleType("MANAGER").build();
		Role crRole = Role.builder().roleType("CORPORATE_REPRESTATIVE").build();
		
		
		roleRepository.save(ownerRole);
		roleRepository.save(managerRole);
		roleRepository.save(crRole);
		
	}

}
