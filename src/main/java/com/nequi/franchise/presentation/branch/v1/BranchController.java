package com.nequi.franchise.presentation.branch.v1;

import com.nequi.franchise.application.BranchService;
import com.nequi.franchise.presentation.dto.branch.BranchPresentationRequest;
import com.nequi.franchise.presentation.dto.branch.BranchPresentationResponse;
import com.nequi.franchise.presentation.mappers.BranchPresentationMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping(path = "/api/v1/branch")
public class BranchController {

    private final BranchService branchService;
    private final BranchPresentationMapper branchPresentationMapper;

    public BranchController(BranchService branchService, BranchPresentationMapper branchPresentationMapper) {
        this.branchService = branchService;
        this.branchPresentationMapper = branchPresentationMapper;
    }

    @PostMapping()
    public Mono<ResponseEntity<BranchPresentationResponse>> create(@RequestBody BranchPresentationRequest branchRequest) {
        return branchService.create(branchPresentationMapper.toApplication(branchRequest))
                .flatMap(response -> Mono.just(
                        ResponseEntity.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(branchPresentationMapper.toInfrastructure(response))
                ));
    }

    @GetMapping()
    public Flux<BranchPresentationResponse> list() {
        return branchService.list()
                .map(branchPresentationMapper::toInfrastructure);
    }
}
