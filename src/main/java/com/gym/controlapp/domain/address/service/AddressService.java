package com.gym.controlapp.domain.address.service;

import com.gym.controlapp.domain.address.dto.AddressPostDto;
import com.gym.controlapp.domain.address.dto.AddressPutDto;
import com.gym.controlapp.config.exception.NotFoundException;
import com.gym.controlapp.domain.address.model.Address;
import com.gym.controlapp.domain.address.repository.AddressRepository;
import com.gym.controlapp.domain.student.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final StudentService studentService;

    public List<Address> listAll() {
        return addressRepository.findAll();
    }

    public Address findByIdOrThrowNotFoundException(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new NotFoundException("Este endereço não existe"));
    }

    @Transactional
    public Address save(AddressPostDto addressPostDto) {
       var student = studentService.listByIdOrThrowNotFoundException(addressPostDto.student_id());
        Address address = Address.builder()
                .cep(addressPostDto.cep())
                .logradouro(addressPostDto.logradouro())
                .complemento(addressPostDto.complemento())
                .bairro(addressPostDto.bairro())
                .localidade(addressPostDto.localidade())
                .uf(addressPostDto.uf())
                .student(student)
                .build();
        return addressRepository.save(address);
    }

    @Transactional
    public Address update(AddressPutDto addressPutDto) {
        var student = studentService.listByIdOrThrowNotFoundException(addressPutDto.student_id());
        var savedAddress = this.findByIdOrThrowNotFoundException(addressPutDto.id());
        Address address = Address.builder()
                .cep(addressPutDto.cep())
                .logradouro(addressPutDto.logradouro())
                .complemento(addressPutDto.complemento())
                .bairro(addressPutDto.bairro())
                .localidade(addressPutDto.localidade())
                .uf(addressPutDto.uf())
                .student(student)
                .build();
        return addressRepository.save(address);
    }

    public void delete(Long id) {
        var address = findByIdOrThrowNotFoundException(id);
        addressRepository.delete(address);
    }
}