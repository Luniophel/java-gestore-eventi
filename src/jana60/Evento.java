package jana60;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	//ATTRIBUTI
	private String titolo;
	private LocalDateTime data;
	private int nPostiTotali, nPostiPrenotati;
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("gg/MM/yyyy, Ore: HH:mm");
	
	//COSTRUTTORI
	public Evento(String titolo, LocalDateTime data, int nPostiTotali) throws Exception
	{
		//Verifica validità dei dati
		boolean datiValidi = true;
		String mexErrore = "ATTENZIONE:\r";
		
		
		try
		{
			validaData(data);
			validaTitolo(titolo);
			validaPostiTotali(nPostiTotali);	
		}
		catch (IllegalArgumentException iae)
		{
				datiValidi = false;
				mexErrore += " " + iae.getMessage();
		}
		catch (Exception e)
		{
			datiValidi = false;
			mexErrore += " " + e.getMessage();
		}
		
		
		if (datiValidi) {
			this.titolo = titolo;
			this.data = data;
			this.nPostiTotali = nPostiTotali;
			this.nPostiPrenotati = 0;
		}
		else
		{
			throw new Exception(mexErrore);
		}
	}
	
	//GETTER / SETTER
	
	//METODI
	private void validaData(LocalDateTime data) throws Exception
	{
		if (data.isBefore(LocalDateTime.now()))
			throw new Exception("L'evento si è già svolto in data:\n" + dtf.format(data));
	}
	
	private void validaTitolo(String titolo) throws IllegalArgumentException
	{
		if (titolo.isBlank())
			throw new IllegalArgumentException("Non puoi lasciare vuoto il titolo dell'evento.");
	}
	
	private void validaPostiTotali(int nPostiTotali) throws IllegalArgumentException
	{
		if (nPostiTotali <= 0)
			throw new IllegalArgumentException("Non puoi inserire 0 o valori negativi.");	
	}
}
