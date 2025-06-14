package com.nequi.franchise.presentation.franchise.v1;

import com.nequi.franchise.application.franchise.FranchiseService;
import com.nequi.franchise.presentation.dto.franchise.FranchiseControllerRequest;
import com.nequi.franchise.presentation.mappers.FranchiseMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping(path = "/api/v1/franchise")
public class FranchiseController {

    private final FranchiseService franchiseService;
    private final FranchiseMapper franchiseMapper;

    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
    }

    @PostMapping()
    public Mono<ResponseEntity<Object>> create(@RequestBody FranchiseControllerRequest franchiseRequest) {
        return franchiseService.create(franchiseMapper.toApplication(franchiseRequest))
                .flatMap(response -> Mono.just(
                        ResponseEntity.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(response)
                ));
    }
}
