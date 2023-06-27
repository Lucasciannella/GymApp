package com.gym.controlapp.domain.address.controller;

import com.gym.controlapp.domain.address.dto.AddressPostDto;
import com.gym.controlapp.domain.address.dto.AddressPutDto;
import com.gym.controlapp.domain.address.model.Address;
import com.gym.controlapp.domain.address.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Address> listAllAdress() {
        return addressService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Address getById(@PathVariable Long id) {
        return addressService.findByIdOrThrowNotFoundException(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Address save(@Valid @RequestBody AddressPostDto addressPostDto) {
        return addressService.save(addressPostDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Address update(@Valid @RequestBody AddressPutDto addressPutDto) {
        return addressService.update(addressPutDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }
}