package jana60;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ProgrammaEventi {

	public static void main(String[] args) {

		try
		{
			
			List<Evento> listaEventi = new ArrayList<Evento>();
			Evento ev1 = new Evento("EXPO 2024", LocalDateTime.of(2024, 7, 12, 10, 00), 5000);
			Evento ev2 = new Evento("Comics 2024", LocalDateTime.of(2024, 7, 12, 10, 00), 2500);
			Evento ev3 = new Evento("Presentazione Bethesda games", LocalDateTime.of(2026, 12, 9, 18, 00), 700);
			Evento ev4 = new Evento("Mondiali eSports LoL", LocalDateTime.of(2022, 10, 26, 10, 00), 500);
			Evento ev5 = new Evento("Nintendo Direct", LocalDateTime.of(2022, 11, 15, 8, 00), 500);
			Evento ev6 = new Evento("Torneo Tekken", LocalDateTime.of(2022, 7, 15, 8, 00), 500);
			Evento ev7 = new Evento("Campionato Mondiale di Briscola", LocalDateTime.of(2022, 7, 17, 6, 00), 10);

			listaEventi.add(ev1);
			listaEventi.add(ev2);
			listaEventi.add(ev3);
			listaEventi.add(ev4);
			listaEventi.add(ev5);
			listaEventi.add(ev6);
			listaEventi.add(ev7);

			
			//LISTA NON ORDINATA
			System.out.println("Lista non ordinata:");
			Iterator<Evento> iter = listaEventi.iterator();
			while (iter.hasNext()) 
			{
				Evento current = iter.next();
			    System.out.println(current);
			}
			System.out.println("__________________________");
			 
			listaEventi.sort(new EventoComparebyData()); //METODO PER RIORDINARE
			 
			//LISTA ORDINATA
			System.out.println("Lista ordinata:");
			iter = listaEventi.iterator();
			while (iter.hasNext()) 
			{
				Evento current = iter.next();
				System.out.println(current);
			}
			System.out.println("__________________________");
		
			//LISTA EVENTI PRE MESE E POST MESE
			List<Evento> listaEventiVicini = new ArrayList<Evento>();
			List<Evento> listaEventiLontani = new ArrayList<Evento>();
			
			//SMISTAMENTO
			iter = listaEventi.iterator();
			while (iter.hasNext())
			{
				Evento current = iter.next();
				long diff = ChronoUnit.MONTHS.between(LocalDateTime.now(), current.getData());
				if (diff < 1)
					listaEventiVicini.add(current);
				else
					listaEventiLontani.add(current);
			}
			
			System.out.println("Lista eventi tra meno di un mese:");
			iter = listaEventiVicini.iterator();
			while (iter.hasNext())
			{
				Evento current = iter.next();
				System.out.println(current);
			}
			System.out.println("__________________________");
			
			System.out.println("Lista eventi tra più di un mese:");
			iter = listaEventiLontani.iterator();
			while (iter.hasNext())
			{
				Evento current = iter.next();
				System.out.println(current);
			}
			System.out.println("__________________________");

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
