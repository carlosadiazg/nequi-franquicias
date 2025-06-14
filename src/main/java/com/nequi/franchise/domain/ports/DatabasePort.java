package com.nequi.franchise.domain.ports;

import reactor.core.publisher.Mono;

public interface DatabasePort {

    Mono<Object> insert();
}
