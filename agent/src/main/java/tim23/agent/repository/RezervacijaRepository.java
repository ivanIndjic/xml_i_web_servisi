package tim23.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tim23.agent.model.Agent;
import tim23.agent.model.Rezervacija;

public interface RezervacijaRepository extends JpaRepository<Rezervacija, Integer>{
	public List<Rezervacija> findBySobaIdAgenta(Agent agent);
	public Rezervacija findByIdRezervacije(Integer id);

}
