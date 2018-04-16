import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Stack {
	
	Node head = null; //Top
	
	public boolean isEmpty()
	{
		return head == null ? true : false; 	//Condicional ternario: if head == null esta vacio; si no, retorna falso
	}
	public void push(Node newNode)
	{
		newNode.next = head;		//No perder de vista el nodo que era la cabeza
		head = newNode;				//Adicionar al comienzo; nueva cabeza
	}
	public String pop()
	{
		Node temp = head;				//Nodo temporal
		head = head.next;				//Cabeza sera el ultimo
		String info = temp.toString();	//OBTENER LA INFORMACION DEL NODO A ELIMINAR
		temp = null;					//
		System.gc();					//Llamado al garbage collector
		return info;
	}
	public String peak()
	{
		Node temp = head;
		String info = temp.toString();
		return info;
	}
	public void printStack()
	{
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//Node temp = head;
		
		try 
		{
			//bw.write("Grades: ");
			while(!isEmpty())
			{
				bw.write(pop());	//
				//temp = temp.next;				//Hacer el recorrido sobre la lista hasta que se acabe (== null)
			}
			bw.flush();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		Stack grades = new Stack();
		grades.push(new Node("Task 1", 3.5));
		grades.push(new Node("Task 2", 4.5));
		grades.push(new Node("Task 3", 2.5));
		grades.push(new Node("Task 4", 1.5));
		grades.printStack();
		
	}
	
}
