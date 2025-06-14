package com.nequi.franchise.application.franchise;

import com.nequi.franchise.domain.Franchise;
import com.nequi.franchise.domain.repository.FranchiseRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FranchiseService {

    private final FranchiseRepository franchiseRepository;

    public FranchiseService(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    public Mono<Franchise> create(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }
}
