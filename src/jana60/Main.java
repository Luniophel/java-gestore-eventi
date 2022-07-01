package jana60;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Importazioni
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Benvenuto/a nel gestore eventi.");
		boolean continua = true; //flag per gestire l'andamento del programma
		String input;
		
		Evento evento = null; //Oggetto inizializzato come valore null, per salvarne i dati dopo il try
		Conferenza conferenza = null;
		
		//Valori che mi dicono quale print fare alla fine, per testing
		boolean isEvento = false;
		boolean isConferenza = false;

		
		do {
			try
			{
				//Richiesta del titolo
				System.out.print("Inserisci il Titolo dell'evento: ");
				String tempTitolo = scan.nextLine();
				
				
				//Richiesta valori per la data
				System.out.println("Inserisci la data dell'evento");
				System.out.print("Giorno: ");
				input = scan.nextLine();
				int tempGiorno = Integer.parseInt(input);
				System.out.print("Mese: ");
				input = scan.nextLine();
				int tempMese = Integer.parseInt(input);
				System.out.print("Anno: ");
				input = scan.nextLine();
				int tempAnno = Integer.parseInt(input);

				//Richiesta valori per l'ora
				System.out.println("Inserisci l'ora dell'evento\r(Digita prima le ore, poi i minuti)");
				System.out.print("Ore: ");
				input = scan.nextLine();
				int tempOre = Integer.parseInt(input);
				System.out.print("Minuti: ");
				input = scan.nextLine();
				int tempMinuti = Integer.parseInt(input);
				
				//Costruzione data dell'evento
				LocalDateTime tempData = LocalDateTime.of(tempAnno, tempMese, tempGiorno, tempOre, tempMinuti);
				
				//Richiesta capienza massima
				System.out.println("Quanti sono i posti totali?");
				input = scan.nextLine();
				int tempnPosti = Integer.parseInt(input);
				
				do
				{
					System.out.println("Si tratta di una conferenza?");
					System.out.println("1 - SI; 2 - NO;");
					input = scan.nextLine();
				
					switch (input) 
					{
						case "1":
							
							System.out.println("Inserisci l'argomento della conferenza: ");
							String tempArgomento = scan.nextLine();
							
							System.out.println("Dati oratore");
							System.out.print("Nome: ");
							String tempNome = scan.nextLine();
							System.out.print("Cognome: ");
							String tempCognome = scan.nextLine();
							System.out.print("Titolo: ");
							String tempTitoloOratore = scan.nextLine();

							Oratore tempOratore = new Oratore(tempNome, tempCognome, tempTitoloOratore);
							//Cotruzione oggetto con i dati provvisori inseriti dall'utente
							conferenza = new Conferenza(tempTitolo, tempData, tempnPosti, tempArgomento, tempOratore);
							isConferenza = true;
							continua = true;
							break;
						
						case "2":
							//Cotruzione oggetto con i dati provvisori inseriti dall'utente
							//In questo caso, non si tratta di una conferenza
							evento = new Evento(tempTitolo, tempData, tempnPosti);
							isEvento = true;
							continua = true;
							break;
						
						default:
							System.out.println("Valore non valido, riprova.");
							continua = false;
							break;
					
					}
					
				}
				while (!continua);
				
				if (isEvento)
					System.out.println("\nEvento " + evento.getTitolo() + " creato con successo.");
				if (isConferenza)
					System.out.println("\nConferenza " + conferenza.getTitolo() + " creata con successo.");

			}
			catch (NumberFormatException nfe)
			{
				System.out.println("Valore non valido. Devi inserire un numero.");
				continua = false;
			}
			catch (Exception e)
			{
				System.out.println("ERRORE: Qualcosa è andato storto..");
				System.out.println(e.getMessage());
				continua = false;
			}
			
		} while (!continua);
		
		if (isEvento)
		{
			do {
				
				System.out.println("Prenotazioni attuali: " + evento.getnPostiPrenotati());
				System.out.println("Ci sono ancora " + evento.postiDisponibili() + " posti disponibili.");
				System.out.println("Cosa vuoi fare?");
				System.out.println("1 - Prenota; 2 - Disdici; 3 - Chiudi;");
				input = scan.nextLine();
				
				switch (input) {
				case "1": 
					try 
					{
						System.out.println("Quanti posti vuole prenotare?");
						int numPrenota = Integer.parseInt(scan.nextLine());
						evento.prenota(numPrenota);
						continua = false;
						break;
					} 
					catch (NumberFormatException nfe)
					{
						System.out.println("Valore non valido. Devi inserire un numero.");
						continua = false;
					}
					catch (Exception e)
					{
						System.out.println("ERRORE: Qualcosa è andato storto..");
						System.out.println(e.getMessage());
						continua = false;
					}
					
				case "2": 
					try 
					{
						System.out.println("Quanti posti vuole disdire?");
						int numDisdici = Integer.parseInt(scan.nextLine());
						evento.disdici(numDisdici);
						continua = false;
						break;
					} 
					catch (NumberFormatException nfe)
					{
						System.out.println("Valore non valido. Devi inserire un numero.");
						continua = false;
					}
					catch (Exception e)
					{
						System.out.println("ERRORE: Qualcosa è andato storto..");
						System.out.println(e.getMessage());
						continua = false;
					}

				case "3":
					continua = true;
					break;
					
				default:
					System.out.println("Valore non valido, riprova.");
					continua = false;
					break;
				}
			} while (!continua);
		}
		
		if (isConferenza)
		{
			do {
				
				System.out.println("Prenotazioni attuali: " + conferenza.getnPostiPrenotati());
				System.out.println("Ci sono ancora " + conferenza.postiDisponibili() + " posti disponibili.");
				System.out.println("Cosa vuoi fare?");
				System.out.println("1 - Prenota; 2 - Disdici; 3 - Chiudi;");
				input = scan.nextLine();
				
				switch (input) {
				case "1": 
					try 
					{
						System.out.println("Quanti posti vuole prenotare?");
						int numPrenota = Integer.parseInt(scan.nextLine());
						conferenza.prenota(numPrenota);
						continua = false;
						break;
					} 
					catch (NumberFormatException nfe)
					{
						System.out.println("Valore non valido. Devi inserire un numero.");
						continua = false;
					}
					catch (Exception e)
					{
						System.out.println("ERRORE: Qualcosa è andato storto..");
						System.out.println(e.getMessage());
						continua = false;
					}
					
				case "2": 
					try 
					{
						System.out.println("Quanti posti vuole disdire?");
						int numDisdici = Integer.parseInt(scan.nextLine());
						conferenza.disdici(numDisdici);
						continua = false;
						break;
					} 
					catch (NumberFormatException nfe)
					{
						System.out.println("Valore non valido. Devi inserire un numero.");
						continua = false;
					}
					catch (Exception e)
					{
						System.out.println("ERRORE: Qualcosa è andato storto..");
						System.out.println(e.getMessage());
						continua = false;
					}

				case "3":
					continua = true;
					break;
					
				default:
					System.out.println("Valore non valido, riprova.");
					continua = false;
					break;
				}
			} while (!continua);
		}
		
		System.out.println("Ecco la conferenza creata:");
		if (isEvento)
			System.out.println(evento);
		if (isConferenza)
			System.out.println(conferenza);

		
		scan.close();
	}

}
