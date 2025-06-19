package com.nequi.franchise.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.nequi.franchise.domain.Product;
import com.nequi.franchise.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Mono<Product> create(Product product) {
        return productRepository.save(product);
    }

    public Flux<Product> list() {
        return productRepository.findAll();
    }

    public Mono<Product> listById(Long id) {
        return productRepository.findById(id);
    }

    public Mono<Void> delete(Long id) {
        return productRepository.delete(id);
    }

    public Flux<Product> findMaxStockByIdFranchise(Long id) {
        return productRepository.findMaxStockByIdFranchise(id);
    }

    public Mono<Product> update(Long id, JsonPatch body) {
        return productRepository.findById(id)
                .switchIfEmpty(Mono.error(new NoSuchElementException("Product not found")))
                .flatMap(p -> {
                    Product product = applyPatch(body, p);
                    return productRepository.save(product);
                });
    }

    private Product applyPatch(JsonPatch patch, Product product) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode patched = patch.apply(objectMapper.convertValue(product, JsonNode.class));
            return objectMapper.treeToValue(patched, Product.class);
        } catch (JsonPatchException | JsonProcessingException e) {
            return product;
        }
    }
}
