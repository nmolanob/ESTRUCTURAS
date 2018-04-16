import java.awt.RadialGradientPaint;
import java.io.*;
import java.util.Random;

public class Sort {
	
	// the array parameter pass on like reference so we can use a void method
	public int[] bubbleSort(int[] unsorted)
	{
		boolean swap = false;
		int temp;
		
		do
		{
			swap = false;
			for(int i=0; i<unsorted.length-1; i++)
			{
				if(unsorted[i]>unsorted[i+1])
				{
					temp = unsorted[i];
					unsorted[i] = unsorted[i+1];
					unsorted[i+1] = temp;
					swap = true;
				}
			}
		}while (swap);
		
		
		return null;
	}
	
	public void printArray(int[] array) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<array.length; i++)
			bw.write(array[i] + " ");
			
		bw.write("\n");
		bw.flush();
		
	}
	
	public void insertionSort(int[] unsorted)
	{
		int temp, indexHole;
		for(int i =1; i<unsorted.length;i++)
		{
			temp = unsorted[i];
			indexHole = i;
			
			while(indexHole > 0 && unsorted[indexHole-1] > temp )
			{
				unsorted[indexHole] = unsorted[indexHole-1];
				indexHole -= 1;				
			}
			
			unsorted[indexHole] = temp;
		}
	}
	
	public int[] bigArray(int length)
	{
		Random rd = new Random();
		int[] temp = new int[length];
		
		for(int i=0; i<length; i++)
			temp[i] = rd.nextInt(20);
		
		return temp;
		
	}
	
	public int[] mergeSort(int[] unsorted) 
	{
		int size;
		if(unsorted.length > 1)
		{
			size = unsorted.length /2;
			int[] left_array = new int[size];
			int[] right_array = new int[unsorted.length-size]; 
			
			for(int i=0; i < size; i++)
				left_array[i] = unsorted[i];
			
			for(int i = size; i < unsorted.length; i++)
				right_array[i - size] = unsorted[i];
			
			return merge(mergeSort(left_array), mergeSort(right_array));
		}
		return unsorted;
	}
	
	public int[] merge(int[] A, int[] B)
	{
		int l = A.length + B.length;
		int [] c =  new int[l];
		int indexA = 0, indexB = 0, indexC = 0;
		
		while(indexA < A.length && indexB < B.length)
		{
			if(A[indexA] < B[indexB])
			{
				c[indexC] = A[indexA];
				indexA++;
				
			}
			else
			{
				c[indexC] = B[indexB];
				indexB++;
			}
			
			indexC++;
		}
		
		while(indexA < A.length)
		{
			c[indexC] = A[indexA];
			indexA++;
			indexC++;
		}
		
		while(indexB < B.length)
		{
			c[indexC] = B[indexB];
			indexB++;
			indexC++;
		}
		
		return c;
	}
	
	public void countingSort(int[] unsorted) //ORDENAMIENTO
	{
		int max = Integer.MIN_VALUE;
		int aux[];
		int index = 0;
		
		for(int i = 0; i < unsorted.length; i++)   //Hallar el valor maximo del arreglo
		{
			if(unsorted[i] > max)
				max = unsorted[i];
		}
		
		aux = new int[max + 1];
		//Aumentar un contador por indice del arreglo auxiliar
		for(int i = 0; i < unsorted.length; i++)
			aux[unsorted[i]] +=1;
		
		for(int i = 0; i < aux.length; i++)
			for(int j = 0; j < aux[i]; j++)
			{
				unsorted[index] = i;
				index += 1;
			}
		
	}
	
	public static int binarySearchRec(int[] arreglo, int valor, int inf, int sup){
		int mitad = (inf+sup)/2;
		if ((inf >= sup) && (arreglo[inf] != valor)){
			return -1;
		}
		else if (arreglo[mitad] == valor){
			return mitad;
		}
		else if (valor > arreglo[mitad]){
			return binarySearchRec (arreglo, valor, mitad+1, sup);
		}
		return binarySearchRec (arreglo, valor, inf, mitad-1);
	} 
	
	public int  binarySearchWithoutRec(int[] array, int value)
	{
		int lowerBound = 0;
		int upperBound = array.length -1;
		int index = -1;
		
		while(lowerBound < upperBound)
		{
			int pointmiddle = (lowerBound + upperBound)/2;
			if(value == array[pointmiddle])
			{
				index = pointmiddle;
				break;
			}
			else if(value < array[pointmiddle])
				upperBound = pointmiddle - 1;
			else lowerBound = pointmiddle + 1;
		}
		
		if(lowerBound == upperBound && array[lowerBound] == value)
			index = lowerBound;
		
		return index;
	}
	
	
	public static void main(String[] args) throws IOException
	{
		Sort st = new Sort();
		int[] a = st.bigArray(40);
		int[] b = a.clone();
		//int[] c = new int[40];
 		//st.printArray(a);
		//a = st.mergeSort(a);
		st.countingSort(a);
		//st.printArray(a);
		
		//System.arraycopy(st.countingSort(a), 0, c, 0, c.length);
		//st.binarySearchRec(a, 3, 0, 15);
		st.printArray(a);
		st.binarySearchWithoutRec(a, -2);
		System.out.println(st.binarySearchWithoutRec(a, 6));
		System.out.println(st.binarySearchRec(a, 6, 0, 30));
		/*
		System.out.println("B");
		
		st.printArray(b);
		st.bubbleSort(b);
		st.printArray(b); */
		
	}
}
