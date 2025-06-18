package com.nequi.franchise.application;

import com.nequi.franchise.domain.Branch;
import com.nequi.franchise.domain.Franchise;
import com.nequi.franchise.domain.repository.BranchRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BranchService {

    private final BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public Mono<Branch> create(Branch branch) {
        return branchRepository.save(branch);
    }

    public Flux<Branch> list() {
        return branchRepository.findAll();
    }

    public Mono<Branch> listById(Long id) {
        return branchRepository.findById(id);
    }
}
