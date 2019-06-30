package tim23.hotelservice.endpoint;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//
//import tim23.hotelservice.model.poruke.GetSobaRequest;
//import tim23.hotelservice.model.poruke.GetSobaResponse;
//import tim23.hotelservice.model.poruke.Soba;

import tim23.hotelservice.model.Adresa;
import tim23.hotelservice.model.Agent;
import tim23.hotelservice.model.Cena;
import tim23.hotelservice.model.DodatneUsluge;
import tim23.hotelservice.model.KategorijaSmestaja;
import tim23.hotelservice.model.KrajnjiKorisnik;
import tim23.hotelservice.model.Poruka;
import tim23.hotelservice.model.Rezervacija;
import tim23.hotelservice.model.Slika;
import tim23.hotelservice.model.Soba;
import tim23.hotelservice.model.SobeDodatneUsluge;
import tim23.hotelservice.model.TipSmestaja;
import tim23.hotelservice.model.poruke.GetAdresaListRequest;
import tim23.hotelservice.model.poruke.GetAdresaListResponse;
import tim23.hotelservice.model.poruke.GetAgentListRequest;
import tim23.hotelservice.model.poruke.GetAgentListResponse;
import tim23.hotelservice.model.poruke.GetAgentRequest;
import tim23.hotelservice.model.poruke.GetAgentResponse;
import tim23.hotelservice.model.poruke.GetCenaRequest;
import tim23.hotelservice.model.poruke.GetCenaResponse;
import tim23.hotelservice.model.poruke.GetDodatneUslugeListRequest;
import tim23.hotelservice.model.poruke.GetDodatneUslugeListResponse;
import tim23.hotelservice.model.poruke.GetKategorijaRequest;
import tim23.hotelservice.model.poruke.GetKategorijaResponse;
import tim23.hotelservice.model.poruke.GetMessageSendRequest;
import tim23.hotelservice.model.poruke.GetMessageSendResponse;
import tim23.hotelservice.model.poruke.GetPorukaListRequest;
import tim23.hotelservice.model.poruke.GetPorukaListResponse;
import tim23.hotelservice.model.poruke.GetReservationListRequest;
import tim23.hotelservice.model.poruke.GetReservationListResponse;
import tim23.hotelservice.model.poruke.GetRezervacijaRequest;
import tim23.hotelservice.model.poruke.GetRezervacijaResponse;
import tim23.hotelservice.model.poruke.GetSlikaRequest;
import tim23.hotelservice.model.poruke.GetSlikaResponse;
import tim23.hotelservice.model.poruke.GetSobaDodatnaUslugaRequest;
import tim23.hotelservice.model.poruke.GetSobaDodatnaUslugaResponse;
import tim23.hotelservice.model.poruke.GetSobaRequest;
import tim23.hotelservice.model.poruke.GetSobaResponse;
import tim23.hotelservice.model.poruke.GetTipSmestajaListRequest;
import tim23.hotelservice.model.poruke.GetTipSmestajaListResponse;
import tim23.hotelservice.repository.AdresaRepository;
import tim23.hotelservice.repository.AgentRepository;
import tim23.hotelservice.repository.CenaRepository;
import tim23.hotelservice.repository.DodatneUslugeRepository;
import tim23.hotelservice.repository.KategorijaSmestajaRepository;
import tim23.hotelservice.repository.KrajnjiKorisnikRepository;
import tim23.hotelservice.repository.PorukaRepository;
import tim23.hotelservice.repository.RezervacijaRepository;
import tim23.hotelservice.repository.SlikaRepository;
import tim23.hotelservice.repository.SobaDodatnaUslugaRepository;
import tim23.hotelservice.repository.SobaRepository;
import tim23.hotelservice.repository.TipSmestajaRepository;
import tim23.hotelservice.service.DodatneUslugeService;
import tim23.hotelservice.service.SobaService;

@Endpoint
public class HotelEndpoint {
	
	@Autowired
	private AgentRepository agentRepository;
	
	@Autowired
	private RezervacijaRepository rezervacijaRepository;
	
	@Autowired
	private KrajnjiKorisnikRepository krajnjiKorisnikRepository;
	
	@Autowired
	private SobaRepository sobaRepository;
	
	@Autowired
	private KategorijaSmestajaRepository kategorijaRepository;
	
	@Autowired
	private AdresaRepository adresaRepository;
	
	@Autowired
	private TipSmestajaRepository tipSmestajaRepository;
	
	@Autowired
	private DodatneUslugeRepository dodatneUslugeRepository;
	
	@Autowired
	private SobaDodatnaUslugaRepository sobeDodatnaUslugaRepository;
	
	@Autowired
	private DodatneUslugeService dodatneUslugeService;
	
	@Autowired
	private SobaService sobaService;
	
	@Autowired
	private CenaRepository cenaRepository;
	
	@Autowired
	private PorukaRepository porukaRepository;
	
	@Autowired
	private SlikaRepository slikaRepository;
	
	
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getAgentRequest")
    @ResponsePayload
	public GetAgentResponse getAgent(@RequestPayload GetAgentRequest request) {
		Agent a = agentRepository.findByUsername(request.getUsername());
    	
		GetAgentResponse response = new GetAgentResponse();
		response.setAgent(a);
		
		return response;
	}
    
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getAgentListRequest")
    @ResponsePayload
    public GetAgentListResponse getAgentList(@RequestPayload GetAgentListRequest request) {
    	List<Agent> a = agentRepository.findAll();
    	
    	GetAgentListResponse response = new GetAgentListResponse();
    	response.setAgent(a);
    	
    	return response;
    }
    
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getReservationListRequest")
    @ResponsePayload
    public GetReservationListResponse getReservationList(@RequestPayload GetReservationListRequest request) {
    	Agent a = agentRepository.findByUsername(request.getUsername());
    	List<Rezervacija> rezervacije = rezervacijaRepository.findBySobaIdAgenta(a);
    	
    	GetReservationListResponse response = new GetReservationListResponse();
    	response.setReservations(rezervacije);
    	
    	return response;
    }
    
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getSobaRequest")
    @ResponsePayload
    public GetSobaResponse getSoba(@RequestPayload GetSobaRequest request) {
    	
    	Soba s = request.getSoba();
    	Soba soba = sobaRepository.save(s);

    	GetSobaResponse response = new GetSobaResponse();
    	response.setSoba(soba);
    	
    	return response;
    }

    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getAdresaListRequest")
    @ResponsePayload
    public GetAdresaListResponse getSoba(@RequestPayload GetAdresaListRequest request) {
    	List<Adresa> adrese = adresaRepository.findAll();
    	GetAdresaListResponse response = new GetAdresaListResponse();
    	response.setAdrese(adrese);
    	return response;
    }
    
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getTipSmestajaListRequest")
    @ResponsePayload
    public GetTipSmestajaListResponse getSoba(@RequestPayload GetTipSmestajaListRequest request) {
    	List<TipSmestaja> tipoviSmestaja = tipSmestajaRepository.findAll();
    	GetTipSmestajaListResponse response = new GetTipSmestajaListResponse();
    	response.setTipoviSmestaja(tipoviSmestaja);
    	return response;
    }
    
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getDodatneUslugeListRequest")
    @ResponsePayload
    public GetDodatneUslugeListResponse getUsluge(@RequestPayload GetDodatneUslugeListRequest request) {
    	List<DodatneUsluge> dodatneUsluge = dodatneUslugeRepository.findAll();
    	GetDodatneUslugeListResponse response = new GetDodatneUslugeListResponse();
    	response.setDodatneUsluge(dodatneUsluge);
    	return response;
    }
    
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getSobaDodatnaUslugaRequest")
    @ResponsePayload
    public GetSobaDodatnaUslugaResponse getSobaDodatneUsluge(@RequestPayload GetSobaDodatnaUslugaRequest request) {
    	
    	SobeDodatneUsluge sobeDodatnaUsluga = request.getSobaDodatnaUsluga();
    	DodatneUsluge usluga = sobeDodatnaUsluga.getDodatnaUsluga();
    	DodatneUsluge zaDodavanje = dodatneUslugeService.get(usluga.getId());
    	Soba soba = sobeDodatnaUsluga.getSoba();
    	Soba sobaZaDodavanje = sobaService.get(soba.getIdSoba());
    	SobeDodatneUsluge zaBazu = new SobeDodatneUsluge();
    	zaBazu.setDodatnaUsluga(zaDodavanje);
    	zaBazu.setSoba(sobaZaDodavanje);
    	SobeDodatneUsluge s = sobeDodatnaUslugaRepository.save(zaBazu);
    	GetSobaDodatnaUslugaResponse response = new GetSobaDodatnaUslugaResponse();
    	response.setSobeDodatnaUsluga(s);
    	return response;
    	
    }
    
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getCenaRequest")
    @ResponsePayload
    public GetCenaResponse addPrice(@RequestPayload GetCenaRequest request) {
    	Cena cenaZaDodavanje = request.getCena();
    	Cena dodata = cenaRepository.save(cenaZaDodavanje);
    	
    	GetCenaResponse response = new GetCenaResponse();
    	response.setCena(dodata);
    	return response;
    }
    
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getPorukaListRequest")
    @ResponsePayload
    public GetPorukaListResponse readMessage(@RequestPayload GetPorukaListRequest request) {
    	Agent a = request.getAgent();
    	Agent trazeni = agentRepository.findById(a.getIdKorisnika()).get();
    	GetPorukaListResponse response = new GetPorukaListResponse();
    	List<Poruka> listaAgentovihPoruka = porukaRepository.findByAgentPrimalac(trazeni);
    	response.setPoruke(listaAgentovihPoruka);
    	return response;
    }
    
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getMessageSendRequest")
    @ResponsePayload
    public GetMessageSendResponse sendMessage(@RequestPayload GetMessageSendRequest request) {
    	String agentUsername = request.getPosiljalac();
    	Agent agentPosiljalac = agentRepository.findByUsername(agentUsername);
    	String klijentUsername = request.getPrimalac();
    	KrajnjiKorisnik korisnik = krajnjiKorisnikRepository.findByUsername(klijentUsername);
    	Poruka poruka = new Poruka();
    	poruka.setAgentPosiljac(agentPosiljalac);
    	poruka.setKlijentPrimalac(korisnik);
    	poruka.setSadrzaj(request.getSadrzaj());
    	porukaRepository.save(poruka);
    	return new GetMessageSendResponse();
    }
    
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getRezervacijaRequest")
    @ResponsePayload
    public GetRezervacijaResponse realizujRezervaciju(@RequestPayload GetRezervacijaRequest request) {
    	Rezervacija rezervacijaZaUpdate = rezervacijaRepository.findById(request.getIdRezervacije()).get();
    	rezervacijaZaUpdate.setRealizovana(true);
    	rezervacijaRepository.save(rezervacijaZaUpdate);
    	return new GetRezervacijaResponse();
    }
    
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getSlikaRequest")
    @ResponsePayload
    public GetSlikaResponse addSlika(@RequestPayload GetSlikaRequest request) {
    	
    	byte[] file = request.getSlika();
    	String filename = request.getFilename();
    	Integer idSobe = request.getIdSobe();
    	String username = request.getUsername();
    	    	
    	String folder = "../slike/" + username + "/" + idSobe + "/";
		
		new File(folder).mkdirs();
		
		System.out.println(new File(folder).getAbsolutePath());
		
		Path path = Paths.get(folder + filename);
				
		try {
			Files.write(path, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Soba soba = sobaRepository.findById(idSobe).get();
		
		Slika slika = new Slika();
		slika.setIdSobe(soba);
		slika.setUrlSlike(path.toAbsolutePath().toString());
		
		slikaRepository.save(slika);
		
		return new GetSlikaResponse();
		
    }
    
    @PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/poruke", localPart = "getKategorijaRequest")
    @ResponsePayload
    public GetKategorijaResponse getKategorije(@RequestPayload GetKategorijaRequest request) {
    	List<KategorijaSmestaja> kategorijeSmestaja = kategorijaRepository.findAll();
    	GetKategorijaResponse response = new GetKategorijaResponse();
    	response.setKategorija(kategorijeSmestaja);
    	return response;
    }
}
