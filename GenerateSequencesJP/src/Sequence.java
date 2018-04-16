
public class Sequence {
	
	public String sequence;
	public String chromosome;
	public int start;
	public int end;
	
	public Sequence next = null; //Creacion de apuntador
	
	public Sequence() {};
	
	public Sequence(String sequence, String chromosome, int start, int end) //Constructores para inicializar NODOS
	{
		this.sequence = sequence;
		this.chromosome = chromosome;
		this.start = start;
		this.end = end;
	}
	public String toString()
	{
		return "Sequence: " + this.sequence + "\t Chromosome" + this.chromosome + "\t Start: " + this.start + "\t End: " + this.end + "\n"; 
	}
	
}