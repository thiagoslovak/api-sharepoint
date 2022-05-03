package br.com.eive.apisharepoint.controller;

import br.com.eive.apisharepoint.model.ContactModel;
import br.com.eive.apisharepoint.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping(path = "/contact/customer/{id}")
    public ResponseEntity consultarId(@PathVariable("id") Long id) {
        return contactRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/contact")
    public ContactModel salvar(@RequestBody ContactModel contact) {
        return contactRepository.save(contact);
    }

    @PutMapping(path = "/contact/{id}")
    public void atualizar(@PathVariable("id") Long id,
                          @RequestBody ContactModel contact){

        contactRepository.updateId(contact.getName(), contact.getEmail(), contact.getPhone(), contact.getCellphone(), id);
    }

    @DeleteMapping(path = "/contact/{id}")
    public void delete(@PathVariable("id") Long id) {
        contactRepository.deleteById(id);
    }
}
