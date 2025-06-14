package com.nequi.franchise.infrastructure.database;

import com.nequi.franchise.domain.ports.DatabasePort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DatabaseAdapter implements DatabasePort {

    @Override
    public Mono<Object> insert() {
        return Mono.just("Dato creado");
    }
}
