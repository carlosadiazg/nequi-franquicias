package com.nequi.franchise.presentation.franchise.v1;

import com.nequi.franchise.application.franchise.FranchiseService;
import com.nequi.franchise.domain.Franchise;
import com.nequi.franchise.presentation.dto.franchise.FranchisePresentationRequest;
import com.nequi.franchise.presentation.dto.franchise.FranchisePresentationResponse;
import com.nequi.franchise.presentation.mappers.FranchisePresentationMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping(path = "/api/v1/franchise")
public class FranchiseController {

    private final FranchiseService franchiseService;
    private final FranchisePresentationMapper franchisePresentationMapper;

    public FranchiseController(FranchiseService franchiseService, FranchisePresentationMapper franchisePresentationMapper) {
        this.franchiseService = franchiseService;
        this.franchisePresentationMapper = franchisePresentationMapper;
    }

    @PostMapping()
    public Mono<ResponseEntity<FranchisePresentationResponse>> create(@RequestBody FranchisePresentationRequest franchiseRequest) {
        return franchiseService.create(franchisePresentationMapper.toApplication(franchiseRequest))
                .flatMap(response -> Mono.just(
                        ResponseEntity.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(franchisePresentationMapper.toInfrastructure(response))
                ));
    }

    @GetMapping()
    public Flux<Franchise> list() {
        return franchiseService.list();
    }
}
