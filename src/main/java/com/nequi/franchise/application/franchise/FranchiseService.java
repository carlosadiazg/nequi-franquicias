package com.nequi.franchise.application.franchise;

import com.nequi.franchise.domain.Franchise;
import com.nequi.franchise.domain.ports.DatabasePort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FranchiseService {

    private final DatabasePort databasePort;

    public FranchiseService(DatabasePort databasePort) {
        this.databasePort = databasePort;
    }

    public Mono<Object> create(Franchise franchise) {
        return databasePort.insert();
    }
}
