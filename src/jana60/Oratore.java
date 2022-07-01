package jana60;

public class Oratore {
	
		//ATTRIBUTI
		private String nome, cognome, titolo;

		//COSTRUTTORI
		
		public Oratore(String nome, String cognome, String titolo) throws Exception {
			
			boolean datiValidi = true;
			String mexErrore = "ATTENZIONE:\r";
			
			try {
				validaNome(nome);
			}catch (IllegalArgumentException iae){
				datiValidi=false;
				mexErrore += "\n" + iae.getMessage();
			}
			try {
				validaCognome(cognome);
			}catch (IllegalArgumentException iae){
				datiValidi=false;
				mexErrore += "\n" + iae.getMessage();
			}
			try {
				validaTitolo(titolo);
			}catch (IllegalArgumentException iae){
				datiValidi=false;
				mexErrore += "\n" + iae.getMessage();
			}
			
			if(datiValidi)
			{
				this.nome = nome;
				this.cognome = cognome;
				this.titolo = titolo;
			}
			else
			{
				throw new Exception(mexErrore);
			}
		}


		
		
		
		//GETTER SETTER
		
		public String getNome() {
			return nome;
		}





		public void setNome(String nome) {
			this.nome = nome;
		}





		public String getCognome() {
			return cognome;
		}





		public void setCognome(String cognome) {
			this.cognome = cognome;
		}





		public String getTitolo() {
			return titolo;
		}





		public void setTitolo(String titolo) {
			this.titolo = titolo;
		}


		//VALIDATORI


		private void validaNome(String nome) throws IllegalArgumentException
		{
			if(nome.isBlank())
				throw new IllegalArgumentException("Nome oratore non inserito.");		
		}

		private void validaCognome(String cognome) throws IllegalArgumentException
		{
			if(cognome.isBlank())
				throw new IllegalArgumentException("Cognome oratore non inserito.");		
		}
		
		private void validaTitolo(String titolo) throws IllegalArgumentException
		{
			if(titolo.isBlank())
				throw new IllegalArgumentException("Titolo oratore non inserito.");		
		}

		


}
