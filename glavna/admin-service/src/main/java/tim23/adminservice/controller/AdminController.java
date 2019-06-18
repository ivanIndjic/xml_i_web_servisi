package tim23.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tim23.adminservice.config.JwtConfig;
import tim23.adminservice.model.Administrator;
import tim23.adminservice.model.Agent;
import tim23.adminservice.model.KrajnjiKorisnik;
import tim23.adminservice.repository.AdministratorRepository;
import tim23.adminservice.repository.AgentRepository;
import tim23.adminservice.service.AgentService;
import tim23.adminservice.service.KrajnjiKorisnikService;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private JwtConfig tokenUtils;

	@Autowired
	private AgentService agentService;

	@Autowired
	private KrajnjiKorisnikService krajnjiKorisnikService;

	@PostMapping("/register")
	public ResponseEntity<Agent> registerAgent(@RequestBody Agent agent, HttpServletRequest request) {
		return agentService.registerAgent(agent);
	}

	@GetMapping("/korisnik")
	public ResponseEntity<List<KrajnjiKorisnik>> getKrajnjiKorisnici() {
		return ResponseEntity.ok(krajnjiKorisnikService.getKrajnjiKorisnici());
	}

	@GetMapping("/korisnik/{username}")
	public ResponseEntity<KrajnjiKorisnik> getKrajnjiKorisnik(@PathVariable String username) {
		return krajnjiKorisnikService.getKrajnjiKorisnik(username);
	}

	@PostMapping("/korisnik/{username}/block/{blokiran}")
	public ResponseEntity<KrajnjiKorisnik> setBlokiran(@PathVariable String username, @PathVariable Boolean blokiran) {
		return krajnjiKorisnikService.setBlokiran(username, blokiran);
	}

	@DeleteMapping("/korisnik/{username}/delete/{uklonjen}")
	public ResponseEntity setUklonjen(@PathVariable String username, @PathVariable Boolean uklonjen) {
		return krajnjiKorisnikService.setUklonjen(username, uklonjen);
	}

	//----------------------------------------------
	// TEST
	//----------------------------------------------

//	@Autowired
//	private AdministratorRepository administratorRepository;
//
//	@GetMapping("/")
//	public Administrator hello(HttpServletRequest request) {
//
//		System.out.println("pogodjen");
//
//		String username = tokenUtils.getUsernameFromToken(tokenUtils.getToken(request));
//
//		Administrator a = administratorRepository.findByUsername(username);
//
//		return a;
//	}
}
