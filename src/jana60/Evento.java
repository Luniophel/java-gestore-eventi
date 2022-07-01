package jana60;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	
	
	//ATTRIBUTI
	private String titolo;
	private LocalDateTime data;
	private int nPostiTotali, nPostiPrenotati;
	
	//Formattazione della data + ora dell'evento
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");
	
	
	
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
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public int getnPostiTotali() {
		return nPostiTotali;
	}

	public int getnPostiPrenotati() {
		return nPostiPrenotati;
	}
	
	
	
	//METODI
	public void prenota() throws Exception
	{
		try
		{
			validaData(data);		
		}
		catch (IllegalArgumentException iae)
		{
			throw new Exception("L'evento è già passato.");	
		}
		
		if (nPostiPrenotati == nPostiTotali) //Confronto con == in quanto, per come strutturato, non potrà mai superare il valore massimo.
			throw new Exception("Non ci sono più posti.");
		else
			this.nPostiPrenotati++;
		
	}
	
	public void disdici() throws Exception
	{
		try
		{
			validaData(data);		
		}
		catch (IllegalArgumentException iae)
		{
			throw new Exception("L'evento è già passato.");	
		}
		
		if (nPostiPrenotati == 0) //Confronto con == in quanto, per come strutturato, non potrà mai superare il valore minimo.
			throw new Exception("Non ci sono prenotazioni al momento.");
		else
			this.nPostiPrenotati--;
	}
	
	@Override
	public String toString()
	{
		return dtf.format(data) + " - " + titolo;
	}
	
	
	
	//VALIDATORI
	//Verifica che la data inserita non sia precedente alla data di oggi
	private void validaData(LocalDateTime data) throws IllegalArgumentException
	{
		if (data.isBefore(LocalDateTime.now()))
			throw new IllegalArgumentException("Non è possibile inserire date precedenti all'odierna.");
	}
	//Verifica che il titolo non sia vuoto
	private void validaTitolo(String titolo) throws IllegalArgumentException
	{
		if (titolo.isBlank())
			throw new IllegalArgumentException("Non puoi lasciare vuoto il titolo dell'evento.");
	}
	//Verifica che i posti totali siano maggiori di zero
	private void validaPostiTotali(int nPostiTotali) throws IllegalArgumentException
	{
		if (nPostiTotali <= 0)
			throw new IllegalArgumentException("Non puoi inserire 0 o valori negativi.");	
	}

}
