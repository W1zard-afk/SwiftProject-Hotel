package com.swiftacad.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swiftacad.entity.Client;
import com.swiftacad.repository.ClientRepository;

@RestController
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;

	@RequestMapping(value = "/createOrUpdateClient", method = RequestMethod.POST)
	public ResponseEntity<String> createOrUpdateClient(@RequestBody Client client) {
		if (client.getFirstName() == null || client.getLastName() == null) {
			System.out.println("First or Last name is NULL");
			return new ResponseEntity<String>("First and/or Last name is NULL ", HttpStatus.BAD_REQUEST);
		}
		clientRepository.save(client);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getClientById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Long id) {
		Optional<Client> clientOpt = clientRepository.findById(id);
		if (clientOpt.isPresent()) {
			return new ResponseEntity<>(clientOpt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@RequestMapping(value = "/getClientByName/{first_name}", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getClientByName(@PathVariable(value = "first_name") String first_name) {
		List<Client> clientNames = clientRepository.findByFirstName(first_name);
		
			return new ResponseEntity<>(clientNames, HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value = "/deleteClientById", method = RequestMethod.POST)
	public ResponseEntity<Client> deleteClientById(@RequestBody Client client){
		clientRepository.deleteById(client.getID());
		return new ResponseEntity<Client>(HttpStatus.OK);
	}

}
