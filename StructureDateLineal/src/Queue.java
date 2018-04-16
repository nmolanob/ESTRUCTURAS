
public class Queue {
	
	Node head = null;
	
	public boolean isEmpty()
	{
		return head == null ? true : false; 	//Condicional ternario: if head == null esta vacio; si no, retorna falso
	}
	
	public void enqueue(Node newNode)
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
	
	public String dequeue()				//El String es para salvar la informacion
	{
		Node temp = head;				//Nodo temporal
		head = head.next;				//Cabeza sera el ultimo
		String info = temp.toString();
		temp = null;					//
		System.gc();					//Llamado al garbage collector
		return info;
	}
}
