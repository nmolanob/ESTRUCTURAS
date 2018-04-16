import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class List {
	
	Sequence head = null; 			//Creacion apuntador a vacio (head) tipo Sequence
	
	public boolean isEmpty()
	{
		return head == null ? true : false; 	//Condicional ternario: if head == null esta vacio; si no, retorna falso
	}
	
	public void printList()
	{
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Sequence temp = head;
		
		try 
		{
			//bw.write("Grades: ");
			while(temp != null)
			{
				bw.write((temp.toString()) + "\n");	//
				temp = temp.next;				//Hacer el recorrido sobre la lista hasta que se acabe (== null)
			}
			bw.flush();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void insertAtBegin(Sequence newSequence)
	{
		newSequence.next = head;		//No perder de vista el nodo que era la cabeza
		head = newSequence;				//Adicionar al comienzo; nueva cabeza
	}
	
	public void insertAtEnd(Sequence newSequence)
	{
		if(isEmpty()) 
		{
			head = newSequence;
		}
		else
		{
			Sequence temp = head;
			
			while(temp.next != null)	//Cuando acabe apuntara a null, temp será el ultimo elemento, al que se le agrega 
				temp = temp.next;		//Recorrer la lista
			
			temp.next = newSequence;
		}
		Sequence temp = head;
	}
	public void deleteAtBegin()
	{
		Sequence temp = head;				//Nodo temporal
		head = head.next;				//Cabeza sera el ultimo
		temp = null;					//
		System.gc();					//Llamado al garbage collector
	}
	
	public void deleteAtEnd()
	{
		
		if(isEmpty())
		{
			head = null;
		}
		else 
		{
			Sequence temp = head;
			while(temp.next.next != null) 
			{
				temp = temp.next;
			}
			temp.next = null;
			System.gc();
		}
	}

	public void insertAtIndex(Sequence newSequence, int index)	//No sirve para insertar en la posicion 0 ni ultima
	{
		Sequence temp = head;
		for(int i = 0; i < index - 1; i++) 
			temp = temp.next;
		
		newSequence.next = temp.next;				//El nuevo nodo apuntará al del indice encontrado, y en del indice apunta al nuevo
		temp.next = newSequence;
	}
	
	public void deleteAtIndex(int index)
	{
		Sequence temp = head;
		Sequence toDelete;
		
		for(int i = 0; i < index - 1; i++) 
		{
			temp = temp.next;
		}
		
		toDelete = temp.next;
		temp.next = temp.next.next;
		toDelete = null;
		System.gc();
	}
	
	//Crear el reverso de una lista usando pilas
	/*
	public void reverse()
	{
		Stack tempStack = new Stack();
		Sequence temp = head;
		
		while(temp != null)
		{
			tempStack.push(temp.clone()); 	//Agregar a una lista !!!Tener en cuenta los parametros por referencia, es necesario crear un clon
			temp = temp.next;
		}
		
		head = tempStack.head;
	}*/
	
	
	public static void main(String[] args) {
		List grades = new List(); //Creacion de la lista
				
		
		//grades.deleteAtBegin();
		//grades.deleteAtEnd();
		//grades.reverse();
		grades.printList();
		
		//List reverse = new List();
		
		
	}
}
