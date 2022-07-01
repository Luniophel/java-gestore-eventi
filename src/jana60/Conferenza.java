package jana60;

import java.time.LocalDateTime;

public class Conferenza extends Evento{
	
	private String argomento;
	private Oratore oratore;
	
	public Conferenza(String titolo, LocalDateTime data, int nPostiTotali, String argomento, Oratore oratore) throws Exception {
		super(titolo, data, nPostiTotali);
		
		//Verifica validità dei dati
		boolean datiValidi = true;
		String mexErrore = "ATTENZIONE:\r";
		
		try
		{
			validaArgomento(argomento);
		}
		catch (IllegalArgumentException iae){
			datiValidi = false;
			mexErrore += "\n" + iae.getMessage();
		}
		
		if(datiValidi)
		{
			this.oratore = oratore;
			this.argomento = argomento;
		}
		else
		{
			throw new Exception(mexErrore);
		}
	}

	private void validaArgomento(String argomento) {
		if(argomento.isBlank())
			throw new IllegalArgumentException("Hai lasciato vuoto l'argomento.");			
	}
	
	@Override
	public String toString()
	{
		String confInfo= super.toString();
		confInfo += "\n" +	 "Argomento della conferenza: "	+ 	argomento 						+
					"\n" +	 "Tenuta da: "	+ oratore.getNome() + " " + oratore.getCognome()	+
					"\n" +	 "Titolo professionale: "	+ oratore.getTitolo()					;
		return confInfo;
		
	}

}
