package tim23.agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim23.agent.model.Adresa;
import tim23.agent.model.Agent;
import tim23.agent.model.KategorijaSmestaja;
import tim23.agent.model.Rezervacija;
import tim23.agent.model.TipSmestaja;
import tim23.agent.repository.AdresaRepository;
import tim23.agent.repository.AgentRepository;
import tim23.agent.repository.KategorijeRepository;
import tim23.agent.repository.RezervacijaRepository;
import tim23.agent.repository.TipSmestajaRepository;

@Service
public class AgentService {
	@Autowired
	private TipSmestajaRepository tsr;
	@Autowired
	private AdresaRepository ar;
	@Autowired
	private RezervacijaRepository rr;
	@Autowired
	private AgentRepository agrep;
	@Autowired
	private KategorijeRepository kare;
	
	public Integer findAgentByUsername(String s) {
		Agent a= agrep.findByUsername(s);
		return a.getIdKorisnika();
	}
	
	public void addReservation(Rezervacija r) {
		rr.save(r);
	}
	public List<TipSmestaja> findAllTypesOfRooms() {
		return tsr.findAll();
	}
	public List<KategorijaSmestaja> findAllCategories() {
		return kare.findAll();
	}

	public List<Adresa> findAllAddresses() {
		return ar.findAll();
	}
	
	public Adresa findAddressById(Integer id) {
		return ar.getById(id);
	}
	
	public TipSmestaja findTypeRoomByNaziv(String naziv) {
		return tsr.findByNaziv(naziv);
	}
	public KategorijaSmestaja findCategRoomByNaziv(String naziv) {
		return kare.findByNaziv(naziv);
	}
}
