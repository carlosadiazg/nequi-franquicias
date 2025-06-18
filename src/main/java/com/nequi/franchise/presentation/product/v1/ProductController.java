package com.nequi.franchise.presentation.product.v1;

import com.nequi.franchise.application.ProductService;
import com.nequi.franchise.presentation.dto.product.ProductPresentationRequest;
import com.nequi.franchise.presentation.dto.product.ProductPresentationResponse;
import com.nequi.franchise.presentation.mappers.ProductPresentationMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping(path = "/api/v1/product")
public class ProductController {

    private final ProductService productService;
    private final ProductPresentationMapper productPresentationMapper;

    public ProductController(ProductService productService, ProductPresentationMapper productPresentationMapper) {
        this.productService = productService;
        this.productPresentationMapper = productPresentationMapper;
    }

    @PostMapping()
    public Mono<ResponseEntity<ProductPresentationResponse>> create(@RequestBody ProductPresentationRequest productRequest) {
        return productService.create(productPresentationMapper.toApplication(productRequest))
                .flatMap(response -> Mono.just(
                        ResponseEntity.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(productPresentationMapper.toInfrastructure(response))
                ));
    }

    @GetMapping()
    public Flux<ProductPresentationResponse> list() {
        return productService.list()
                .map(productPresentationMapper::toInfrastructure);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ProductPresentationResponse>> listById(@PathVariable Long id) {
        return productService.listById(id)
                .flatMap(response -> Mono.just(
                        ResponseEntity.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(productPresentationMapper.toInfrastructure(response))
                ));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return productService.delete(id)
                .thenReturn(ResponseEntity.noContent().build());
    }
}
