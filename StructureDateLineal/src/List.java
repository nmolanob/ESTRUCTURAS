import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class List {
	
	Node head = null; 			//Creacion apuntador a vacio (head) tipo Node
	
	public boolean isEmpty()
	{
		return head == null ? true : false; 	//Condicional ternario: if head == null esta vacio; si no, retorna falso
	}
	
	public void printList()
	{
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Node temp = head;
		
		try 
		{
			//bw.write("Grades: ");
			while(temp != null)
			{
				bw.write((temp.toString()));	//
				temp = temp.next;				//Hacer el recorrido sobre la lista hasta que se acabe (== null)
			}
			bw.flush();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void insertAtBegin(Node newNode)
	{
		newNode.next = head;		//No perder de vista el nodo que era la cabeza
		head = newNode;				//Adicionar al comienzo; nueva cabeza
	}
	
	public void insertAtEnd(Node newNode)
	{
		if(isEmpty()) 
		{
			head = newNode;
		}
		else
		{
			Node temp = head;
			
			while(temp.next != null)	//Cuando acabe apuntara a null, temp será el ultimo elemento, al que se le agrega 
				temp = temp.next;		//Recorrer la lista
			
			temp.next = newNode;
		}
		Node temp = head;
	}
	public void deleteAtBegin()
	{
		Node temp = head;				//Nodo temporal
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
			Node temp = head;
			while(temp.next.next != null) 
			{
				temp = temp.next;
			}
			temp.next = null;
			System.gc();
		}
	}

	public void insertAtIndex(Node newNode, int index)	//No sirve para insertar en la posicion 0 ni ultima
	{
		Node temp = head;
		for(int i = 0; i < index - 1; i++) 
			temp = temp.next;
		
		newNode.next = temp.next;				//El nuevo nodo apuntará al del indice encontrado, y en del indice apunta al nuevo
		temp.next = newNode;
	}
	
	public void deleteAtIndex(int index)
	{
		Node temp = head;
		Node toDelete;
		
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
	public void reverse()
	{
		Stack tempStack = new Stack();
		Node temp = head;
		
		while(temp != null)
		{
			tempStack.push(temp.clone()); 	//Agregar a una lista !!!Tener en cuenta los parametros por referencia, es necesario crear un clon
			temp = temp.next;
		}
		
		head = tempStack.head;
	}
	///////////
	public Node binarySearch(int value, int lowerBound, int upperBound)
	{
		int middleElement = (lowerBound + upperBound) / 2;
		int tempId = get(middleElement).id;
		if(lowerBound == upperBound)
		{
			if(tempId == value)
				return get(middleElement);
			else
				return null;
				
		}
		else
		{
			if(tempId == value)
				return get(middleElement);
			else
				if(value < tempId)
					return binarySearch(value, lowerBound, middleElement);
				else
					return binarySearch(value, middleElement + 1, upperBound);
		}
		
		Node next = null;
	}
	///////////OBTENER LONGITUD DE LA LISTA
	public int length() 
	{
		int counter = 0;
		Node temp = head;
		
		while(temp != null)
		{
			counter +=1;
			temp = temp.next;
		}
		return counter;
	}
	////////////NODO PARA ARREGLAR EN LISTAS
	public Node get(int index)
	{
		if(index < this.length())
		{
			Node temp = head;
			for(int i = 0; i < index; i++)
				temp = temp.next;
			return temp;
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		List grades = new List(); //Creacion de la lista
				
		grades.insertAtBegin(new Node("Task 1", 3.5));
		grades.insertAtBegin(new Node("Quiz 1", 5.5));
		grades.insertAtEnd(new Node("Test 1", 2.5));
		grades.insertAtIndex(new Node("Task 3", 4.5), 1);
		//grades.deleteAtBegin();
		//grades.deleteAtEnd();
		grades.reverse();
		grades.printList();
		
		
		Node search = grades.binarySearch(8, 0, grades.length() - 1);
		
		if(search != null)
			System.out.println("Elemento encontrado: " + search.toString());
		else
			System.out.println("El elemento no se encuentra");
			
		//List reverse = new List();
		
		
	}
}
