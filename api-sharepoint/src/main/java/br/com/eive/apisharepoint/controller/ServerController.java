package br.com.eive.apisharepoint.controller;

import br.com.eive.apisharepoint.model.ServerModel;
import br.com.eive.apisharepoint.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ServerController {

    @Autowired
    private ServerRepository serverRepository;

    @GetMapping(path = "/server/customer/{id}")
    public ResponseEntity consultarId(@PathVariable("id") Long id) {
        return serverRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/server")
    public ServerModel salvar(@RequestBody ServerModel server) {
        return serverRepository.save(server);
    }

    @PutMapping(path = "/server/{id}")
    public void atualizar(@PathVariable("id") Long id,
                          @RequestBody ServerModel server){

        serverRepository.updateId(server.getIp(), server.getDns(), server.getLogin(), server.getPassword(),
                server.getName(), server.getNotes(), id);
    }

    @DeleteMapping(path = "/server/{id}")
    public void delete(@PathVariable("id") Long id) {
        serverRepository.deleteById(id);
    }
}
