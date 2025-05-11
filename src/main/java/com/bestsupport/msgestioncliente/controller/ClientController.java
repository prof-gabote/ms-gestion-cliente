package com.bestsupport.msgestioncliente.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestsupport.msgestioncliente.dto.ClientDTO;
import com.bestsupport.msgestioncliente.dto.ClientDTOConverter;
import com.bestsupport.msgestioncliente.model.Client;
import com.bestsupport.msgestioncliente.service.ClientService;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientDTOConverter clientDTOConverter;

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    
    @GetMapping("/status")
    public String getStatus() {
        return "Client service is running";
    }
    
    @GetMapping()
    public ResponseEntity<List<ClientDTO>> getAllClients(){

        List<Client> clients = clientService.getAllClients();
        List<ClientDTO> clientDTOs = new ArrayList<>();

        for (Client client : clients) {
            ClientDTO clientDTO = clientDTOConverter.convert(client);
            clientDTOs.add(clientDTO);
        }

        if (clientDTOs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(clientDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {

        logger.info("Fetching client with id: {}", id);
        Client client = clientService.getClientById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientDTOConverter.convert(client));
    }

    @PostMapping()
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO client) {
        Client createdClient = clientService.saveClient(clientDTOConverter.convert(client));
        if (createdClient == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(clientDTOConverter.convert(createdClient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO client) {
        Client updatedClient = clientService.updateClient(id, clientDTOConverter.convert(client));
        if (updatedClient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientDTOConverter.convert(updatedClient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        boolean deleted = clientService.deleteClient(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
