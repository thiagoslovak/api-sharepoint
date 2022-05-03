package br.com.eive.apisharepoint.controller;


import br.com.eive.apisharepoint.model.ProductModel;
import br.com.eive.apisharepoint.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/product/customer/{id}")
    public ResponseEntity consultarId(@PathVariable("id") Long id)  {
        return productRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/product")
    public ProductModel salvar(@RequestBody ProductModel product) {
        return productRepository.save(product);
    }

    @PutMapping(path = "/product/{id}")
    public void atualizar(@PathVariable("id") Long id,
                          @RequestBody ProductModel product){

        productRepository.updateId(product.getName(), product.getNotes(), product.getAcquisitionDate(), id);
    }

    @DeleteMapping(path = "/product/{id}")
    public void delete(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
    }
}
