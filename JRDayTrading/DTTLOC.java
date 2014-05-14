class DTTLOC // TLOC == "The Law Of Charts"
{
	/**
 	 * dato uno schema grafico, questo metodo ci indica se
 	 * tale grafico presenta lo schema 123 min
 	 * @param graph Grafico da controllare
 	 * @return true se il grafico ha lo schema 123 min, altrimenti false.
 	 * */ 
	public boolean HaSchemaGrafico123Min(DTBar[] graph)
	{
		// individuiamo se siamo in un trend ribassista
		// Assumiamo che se ci sono più di 2 barre successive
		// in ribasso, allora siamo in un trend ribassista
		

		boolean is_ribassista = false; // true se siamo in trend ribassista
		int counter = 0; // Conta quanti ribassi successivi troviamo
		int iBar;

		for(int i = 0 ; i < 3 ; i++ )
		{
			if(graph[i].Low > graph[i+1].Low)
			{
				counter++;
			}

			if(counter == 2)
			{
				is_ribassista = true;
				iBar = i;
				break;
			}	
		}

		if(is_ribassista)
		{
			// partiamo dalla barra in iBar per individuare la barra 1
			// La barra 1 è la prima barra che ha la barra successiva con il Low maggiore del suo
			
			int iBar1 = -1;

			for(int i=iBar; i<graph.length; i++)
			{
				if(graph[i].Low < graph[i+1].Low)
				{
					iBar1 = i;
					break;
				}
			}


			// partiamo dalla barra 1 alla ricerca della barra 2.
			// La barra 2 deve essere entro le 3 barre successive alla barra 1.
			// La barra 2 deve avere il minimo maggiore del minimo della barra 1
			// e deve avere il più grande massimo maggiore del massimo della barra 1.

		}
		else
		{
			return false;
		}
	}
}
