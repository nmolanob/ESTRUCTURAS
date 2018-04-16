import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

	List sequencesList = new List();
	int max_occurrences = Integer.MIN_VALUE;
	String motif_winner = "";
	
	public void compareMotif(String motif_candidate)
	{
		int counter = counterOccurrences(motif_candidate); 
		if(counter > max_occurrences)
		{
			max_occurrences = counter;
			motif_winner = motif_candidate;
		}
	}
	
	public int counterOccurrences(String motif_candidate)
	{
		int counter = 0;
		String gen_sequence;
		
		Sequence temp = sequencesList.head; 
		while(temp != null)
		{
			gen_sequence = temp.sequence; 	 //Obtener las secuencias: ej: ACTGACTGTCGATGCCAA
			
			for(int i = 0; i < (gen_sequence.length() - motif_candidate.length()); i++)		//Mirar las subcadenas hasta el penultimo simbolo
			{
				if(gen_sequence.substring(i, i + motif_candidate.length()).equals(motif_candidate));
				{
					counter += 1;						//Si lo encontro, sume 1
					i += motif_candidate.length() - 1; 	//Si encontró la subcadena, entonces salteese los siguientes (tamanio de la cadena), para no perder tiempo en comparar 
				}
			}
			
			temp = temp.next;				//Recorrer la lista
		}
		
		return counter;
	}
	
	//Función Recursiva para hacer las combinacion posibles, estilo arbol
	public void generateCombinations(String subsequence, int size)
	{
		if(size == 1)
		{
			compareMotif(subsequence + "A");
			compareMotif(subsequence + "C");
			compareMotif(subsequence + "G");
			compareMotif(subsequence + "T");
			
		}
		else
		{
			generateCombinations(subsequence + "A", size - 1);
			generateCombinations(subsequence + "C", size - 1);
			generateCombinations(subsequence + "G", size - 1);
			generateCombinations(subsequence + "T", size - 1);
		}
	}
	
	//
	public void countChromosomes()// throws IOException 
	{
		int[] chromosomes = new int[23];
		String cromosoma;
		int index;
		Sequence temp = sequencesList.head;
		while(temp != null)
		{
			if(temp.sequence.contains(motif_winner))
			{
				//chromosomes[Integer.parseInt(temp.chromosome.replace("chr", "")) - 1] += 1;
				cromosoma = temp.chromosome;
				cromosoma = cromosoma.replace("chr", "");
				index = Integer.parseInt(cromosoma) - 1;
				chromosomes[index] += 1;
			}
			
			temp = temp.next;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < 23; i++)
		{
			System.out.println("Cromosoma " + (i+1) + ": " + chromosomes[i] + "\n");
		}
		//bw.flush();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Leer archivo
		try
		{
			FileReader fr = new FileReader("Sequences.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String input = br.readLine();
			
			Main run = new Main();		//Objeto de tipo Main, para que no genere conflicto con el static de arriba
			
			while(input != null)
			{
				String[] data = input.split(",");
				run.sequencesList.insertAtEnd(new Sequence(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
				input = br.readLine();
			}
			//sequencesList.printList();
			run.generateCombinations("", 4); //
			System.out.println("Motif ganador: " + run.motif_winner + "\tOcurrencias: " + run.max_occurrences + "\n");
			run.countChromosomes();
		}
		catch(Exception ex)
		{
			
		}
		
	}

}
