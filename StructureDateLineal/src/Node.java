
public class Node {
	
	/////////////////////////////DEFINIR EL NODO
	
	String grade;	//Nombre de la nota
	double value;	//Grade (Nota) normalmente es decimal
	
	Node next ;		//Apuntador
	
	public Node() {}	//Constructor vacio
	
	public Node(String grade, int value) //Constructor con los parametros
	{
		this.grade = grade;
		this.id = value;
	}
	public String toString()		//Impresion estetica
	{
		return "Grade: " + this.grade + "\t" + "Value: " + this.id + "\n";
	}
	////////////////////////////////////////////////
	
	public Node clone()		//Crear un nodo con la misma informacion
	{
		Node temp = new Node(this.grade, this.id);
		return temp;
	}
}
