package tim23.searchservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import tim23.searchservice.model.DodatneUsluge;


public interface DodatneUslugeRepository extends JpaRepository<DodatneUsluge, Integer>{
	/*
	public DodatneUsluge findById(Long id);
	public DodatneUsluge findByNaziv(String naziv);
*/
}
