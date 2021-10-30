package com.apirest.webflux.document;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class PlayList {

	@Id
	private String id;
	public PlayList(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	private String nome;
	
	
	public String getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayList other = (PlayList) obj;
		return Objects.equals(id, other.id);
	}
	
}
