package com.apirest.webflux.services;

import org.springframework.stereotype.Service;

import com.apirest.webflux.document.PlayList;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayListService {

	Flux<PlayList> findAll();
	Mono<PlayList> findById(String id);
	Mono<PlayList> save(PlayList playlist);
	
}
