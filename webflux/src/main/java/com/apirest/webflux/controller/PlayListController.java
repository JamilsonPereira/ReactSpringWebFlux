package com.apirest.webflux.controller;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.webflux.document.PlayList;
import com.apirest.webflux.services.PlayListService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/playlist")
public class PlayListController {

	@Autowired
	PlayListService service;

	@GetMapping
	public Flux<PlayList> getMapping(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<PlayList> getId(@PathVariable String id){
		return service.findById(id);
	}
	
	@PostMapping
	public Mono<PlayList> save(@RequestBody PlayList playlist){
		return service.save(playlist);
		
	}
	
	@GetMapping(value="/playlist/webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, PlayList>> getPlaylistByWebflux(){

		System.out.println("---Start get Playlists by WEBFLUX--- " + LocalDateTime.now());
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<PlayList> playlistFlux = service.findAll();

        return Flux.zip(interval, playlistFlux);
        
	}
}
