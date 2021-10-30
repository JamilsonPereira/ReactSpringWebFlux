package com.apirest.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.apirest.webflux.document.PlayList;
import com.apirest.webflux.services.PlayListService;
import static  org.springframework.web.reactive.function.server.ServerResponse.ok ;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import reactor.core.publisher.Mono;

//@Component
public class PlayListHandler {

	@Autowired
	PlayListService playlistService;
	
	public Mono<ServerResponse> findAll(ServerRequest request){
		return ok()
				.contentType(
				MediaType.APPLICATION_JSON)
				.body(playlistService.findAll(), PlayList.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request){
		String id = request.pathVariable("id");
		return ok()
				.contentType(
				MediaType.APPLICATION_JSON)
				.body(playlistService.findById(id), PlayList.class);
	}

	public Mono<ServerResponse> save(ServerRequest request){
		final Mono<PlayList> playlist = request.bodyToMono(PlayList.class);
		return ok()
				.contentType(
				MediaType.APPLICATION_JSON)
				.body(fromPublisher(playlist.flatMap(playlistService::save), PlayList.class));
	}

}
