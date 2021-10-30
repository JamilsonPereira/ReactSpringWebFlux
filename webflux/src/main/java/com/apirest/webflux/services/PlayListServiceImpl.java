package com.apirest.webflux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.webflux.document.PlayList;
import com.apirest.webflux.repository.PlayListRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayListServiceImpl implements PlayListService{

	@Autowired
	PlayListRepository pr;
	
	@Override
	public Flux<PlayList> findAll() {
	
		return pr.findAll();
	}

	@Override
	public Mono<PlayList> findById(String id) {
		
		return pr.findById(id);
	}

	@Override
	public Mono<PlayList> save(PlayList playlist) {
		return pr.save(playlist);
	}

}
