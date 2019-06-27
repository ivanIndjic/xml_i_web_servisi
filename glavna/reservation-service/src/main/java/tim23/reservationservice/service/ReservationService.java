package tim23.reservationservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tim23.reservationservice.model.Agent;
import tim23.reservationservice.model.KrajnjiKorisnik;
import tim23.reservationservice.model.Poruka;
import tim23.reservationservice.model.Rezervacija;
import tim23.reservationservice.model.Soba;
import tim23.reservationservice.repository.AgentRepository;
import tim23.reservationservice.repository.KrajnjiKorisnikRepository;
import tim23.reservationservice.repository.PorukeRepository;
import tim23.reservationservice.repository.ReservationRepository;
import tim23.reservationservice.repository.SobaRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository rr;
	@Autowired
	private SobaRepository sr;
    @Autowired
    private PorukeRepository pr;
    @Autowired
    private KrajnjiKorisnikRepository kkr;
    @Autowired
    private AgentRepository ar;
    
    public KrajnjiKorisnik getByUsername(String username) {
    	return kkr.findByUsername(username);
    }
    
    public Agent getAgent(Integer id) {
    	return ar.findByIdKorisnika(id);
    	
    }
    
    
    public List<Poruka>getPoruke(String username){
    	return pr.getByKlijentPrimalac(username);
    }
    
   public void sacuvaj(Poruka p) {
	   pr.save(p);
   }
   
   public Rezervacija nadjiRezervaciju(Integer id) {
	   return rr.getByIdRezervacije(id);
	   }
   //metoda koja vraca ocenu sobe
   public double dodajOcenu(Integer id) {
       Integer brojac = 0;
       Double suma = 0.0;
       Double izlazSuma = 0.0;
	   List<Rezervacija> rezervacije =rr.findAllBySobaIdSoba(id);
	   for(int i=0;i<rezervacije.size();i++) {
		   if(rezervacije.get(i).getOcena()!=null) {
			 suma+=rezervacije.get(i).getOcena();
			 brojac++;
		   }
	   }
	   izlazSuma = suma/brojac;
	   return izlazSuma;
   }
   
   //metoda koja ocenjuje rezervaciju i update ocenu sobe takodje
   public void OceniRezervacijuIUpdateOcenuSobe(Integer rezervacijaId,Double ocena) {
	   Rezervacija rez = rr.getByIdRezervacije(rezervacijaId);
	   rez.setOcena(ocena);
	   rr.save(rez);
	   Integer id = rez.getIdSobe().getIdSoba();
	   Double revG = dodajOcenu(id);
	   Soba soba = sr.findByIdSoba(id);
	   soba.setOcena(revG);
	   sr.save(soba);
	   
   }
   
   public List<Rezervacija> getReservationByUsername(String username){
	   return rr.findAllByKrajnjiKorisnikUsername(username);
   }

	
	public List<Rezervacija> returnReservationByRoomId(Integer id) {

		List<Rezervacija> lista=rr.findBySobaIdSoba(id);
//		for(Rezervacija lr: lista) {
//			System.out.println(lr.getIdRezervacije());
//		}
		return lista;
	}
	
	public void addReservation(Rezervacija rez) {
		rr.save(rez);
	}

	public boolean CheckIfRoomIsFree(Date dolazak,Date odlazak,Integer id) {
		List<Rezervacija> lista=returnReservationByRoomId(id);
        boolean los=true;
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				//Date date1 = sdf.parse("2015-12-23");
		        //Date date2 = sdf.parse("2015-12-28");
		        for(Rezervacija r : lista) {
		        	if((dolazak.compareTo(r.getDatumOdlaska())>0 && odlazak.compareTo(r.getDatumOdlaska())>0 && dolazak.compareTo(r.getDatumDolaska())>0 && odlazak.compareTo(r.getDatumDolaska())>0)) { //date1 je posle rezervisanog odlaska
		        		
		        	}
		        	else if(dolazak.compareTo(r.getDatumOdlaska())<0 && odlazak.compareTo(r.getDatumOdlaska())<0  && dolazak.compareTo(r.getDatumDolaska())<0 && odlazak.compareTo(r.getDatumDolaska())<0) {
		        		
		        	}else {
		        		los=false;
		        	}
		        }

	       return los;
	}
	
	public Soba findRoomById(Integer id) {
		return sr.findByIdSoba(id);
	}
}
