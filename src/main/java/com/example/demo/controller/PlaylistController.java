package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Song;
import com.example.demo.services.SongService;
import com.example.demo.services.playlistService;

@Controller
public class PlaylistController {

	@Autowired
	SongService service;
	@Autowired
	playlistService playlistservice;

	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model) {
		List<Song> playlist = service.fetchAllSongs();
		model.addAttribute("songs", playlist);
		return "createPlaylist";

	}

	@PostMapping("/addplaylist")
	public String addPlaylist(@ModelAttribute PlayList playlist) {
		playlistservice.addPlaylist(playlist);
		List<Song> songList = playlist.getSongs();
		for (Song s : songList) {
			s.getPalylist().add(playlist);
//juz doin this not suffient we've to update it in database as well;
			service.updateSong(s);// service to update the current row song

		}
		return "adminHome";
	}

	@GetMapping("/viewPlaylist")
	public String viewPlaylist(Model model) {

		List<PlayList> allPlaylists = playlistservice.fetchAllPlaylists();

		// modelattribute is allPlaylists
		model.addAttribute("allPlaylists", allPlaylists);
		return "displayPlaylist";
	}

}
