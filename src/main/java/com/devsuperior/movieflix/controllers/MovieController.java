package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieBasicDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@GetMapping
	public ResponseEntity<Page<MovieBasicDTO>> findAllPaged(
			@RequestParam(value = "genreId", defaultValue = "0") Long genreId,
			@PageableDefault(sort = "title")
			Pageable pageable) {
		Page<MovieBasicDTO> page = service.findAllPaged(genreId, pageable);
		return ResponseEntity.ok().body(page);
	}

}
