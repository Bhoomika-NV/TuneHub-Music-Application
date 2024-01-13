package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String artist;
	String genre;
	String Link;
	@ManyToMany
	List<PlayList>palylist;
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Song(int id, String name, String artist, String genre, String link, List<PlayList> palylist) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		Link = link;
		this.palylist = palylist;
	}
	//@Override
	/*
	 * public String toString() { return "Song [id=" + id + ", name=" + name +
	 * ", artist=" + artist + ", genre=" + genre + ", Link=" + Link + ", palylist="
	 * + palylist + "]"; }
	 */
	
	 
			
 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public List<PlayList> getPalylist() {
		return palylist;
	}
	public void setPalylist(List<PlayList> palylist) {
		this.palylist = palylist;
	}




}
