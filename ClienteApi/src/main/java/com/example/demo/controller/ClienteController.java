package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Dao.IClienteRepository;
import com.example.demo.model.Cliente;

@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	IClienteRepository clienteRepository;

	
	@PostMapping("/Cliente")
	public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente ) {
		
		try {
			Cliente _cliente =	clienteRepository.save(new Cliente(cliente.getNombre(),cliente.getApellidos(),cliente.getCorreo_electronico(),cliente.getNombre_usuario(),
					cliente.getPassword(),cliente.getEdad(),cliente.getEstatura(),cliente.getGeb(),cliente.getImc(),cliente.getPeso()));
			
			return new ResponseEntity<>(_cliente,HttpStatus.CREATED);

		} catch (Exception  e) {
			 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	} 

	@RequestMapping(value = "/Clientes", method = RequestMethod.GET)
	public List<Cliente> getclientes() {
		return clienteRepository.findAll();
	}

	@RequestMapping(value = "/Clientes/{id}", method = RequestMethod.GET)
	public Optional<Cliente> getClientesById(@PathVariable("id") int id) {
		return clienteRepository.findById(id);

	}

	@PutMapping("/Cliente/{id}")
	public ResponseEntity<?> updateCliente(@PathVariable("id") int id, @RequestBody Cliente clientes) {
	
		Optional<Cliente> clienteData = clienteRepository.findById(id);
		if (clienteData.isPresent()) {
			Cliente _cliente = clienteData.get();
			_cliente.setNombre(clientes.getNombre());
			_cliente.setApellidos(clientes.getApellidos());
			_cliente.setNombre_usuario(clientes.getNombre_usuario());
			_cliente.setPassword(clientes.getPassword());
			_cliente.setEdad(clientes.getEdad());
			_cliente.setCorreo_electronico(clientes.getCorreo_electronico());
			_cliente.setGeb(clientes.getGeb());
			_cliente.setImc(clientes.getImc());
			_cliente.setPeso(clientes.getPeso());
			_cliente.setEstatura(clientes.getEstatura());
			
			return new ResponseEntity<>(clienteRepository.save(_cliente), HttpStatus.OK);

			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	 @DeleteMapping("/Clientes/{id}")
	  public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("id") int id) {
	    try {
	    	clienteRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  @DeleteMapping("/Clientes")
	  public ResponseEntity<HttpStatus> deleteAllClientes() {
	    try {
	    	clienteRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}