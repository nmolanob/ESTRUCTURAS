import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class GenerateSequences {
	
	public static String chromosome()			//Traer los cromosomas
	{
		Random rd = new Random();
		return "chr" + (rd.nextInt(23) + 1); 	//Para evitar el switch case
	}
	
	public static String nucleotide()			//Traer bases nucleotidas ACGT
	{
		Random rd = new Random();
		
		switch(rd.nextInt(4))
		{
			case 0: return "A";
			case 1: return "C";
			case 2: return "G";
			case 3: return "T";
			default: return "";
		}
	}
	
	public static String sequence(int length)	//Llamar seg{un el numero de sequences
	{
		if(length == 1)
			return nucleotide();
		else
			return nucleotide() + sequence(length - 1);
	}
	
	public static void saveSequence()
	{
		try
		{
			FileWriter file = new FileWriter("Sequences.txt");
			BufferedWriter bw = new BufferedWriter(file);
			Random rd = new Random();
			int length, start, datasize = 10000;				//datasize: tamanio
			String experimental_read;
			
			for(int i = 0; i < datasize; i++)
			{
				length = rd.nextInt(46) + 5;
				start = rd.nextInt(1000 + 1);
				experimental_read = sequence(length) + "," + chromosome() + "," + start + "," + (start + length -1); //Guardar en string completamente
				bw.write(experimental_read + "\n");				//Escribir en el buffer
			}
			bw.flush();
			bw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Random rd = new Random();
		//int length = rd.nextInt(50) + 1;
		//int start = rd.nextInt(1000);
		//System.out.println(sequence(length) + " "+ chromosome() + " "+ start + " "+ (start + length - 1));
		saveSequence();
	}

}
