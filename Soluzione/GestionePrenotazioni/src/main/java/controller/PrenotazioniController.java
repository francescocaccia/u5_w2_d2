package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enumes.LingueAccettate;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

	@GetMapping("/info/{lingua}")
	public ResponseEntity<String> info(@PathVariable LingueAccettate lingua) {
		if (LingueAccettate.italiano.equals(lingua)) {
			String body = "<h1>La lingua selezionata è italiano</h1>";
			return new ResponseEntity<>(body, HttpStatus.OK);
		} else if (LingueAccettate.inglese.equals(lingua)) {
			String body = "<h1>Selected language is english</h1>";
			return new ResponseEntity<>(body, HttpStatus.OK);
		} else {
			String body = "<h1>la lingua selezionata non esiste / selected language not exist</h1>";
			return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
		}

	}
}
