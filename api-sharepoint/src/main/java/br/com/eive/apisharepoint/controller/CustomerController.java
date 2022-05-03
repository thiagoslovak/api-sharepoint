package br.com.eive.apisharepoint.controller;

import br.com.eive.apisharepoint.model.CustomerModel;
import br.com.eive.apisharepoint.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/customer")
    public List<CustomerModel> consultar(@RequestBody CustomerModel customer) {
        return customerRepository.findByOrderById();
    }

    @GetMapping(path = "/customer/{id}")
    public ResponseEntity consultarId(@PathVariable("id") Long id) {
        return customerRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/customer")
    public CustomerModel salvar(@RequestBody CustomerModel customer) {
        return customerRepository.save(customer);
    }

    @PutMapping(path = "/customer/{id}")
    public void atualizar(@PathVariable("id") Long id,
                          @RequestBody CustomerModel customer){

        customerRepository.updateId(customer.getDbInfo(), customer.getName(), customer.getNotes(), customer.getResponsible(),
                customer.getSegment(), customer.getTier(), id);
    }

    @DeleteMapping(path = "/customer/{id}")
    public void delete(@PathVariable("id") Long id) {
        customerRepository.deleteById(id);
    }
}
