import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InversionCountX {
	static long inversionByDivideAndConquer =0;
	static long inversionByInsertion =0;
	public void inversionCount(int[] a,int[] aux,int lo,int hi){

		if(lo>=hi) return ;
			int mid = lo+(hi-lo)/2;
			 inversionCount(a,aux,lo,mid);
			 inversionCount(a,aux,mid+1,hi);
			  merge(a,aux,lo,mid,hi);
	}

	private void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		// TODO Auto-generated method stub
		int i =lo;
		int j =mid+1;
		for(int c =lo;c<=hi;c++){
			aux[c] = a[c];
		}
		for(int k=lo;k<=hi;k++){
			if(i>mid) a[k] = aux[j++];
			else if(j>hi) a[k] = aux[i++];
			else if(aux[j]<aux[i]){
				a[k] = aux[j++];
				inversionByDivideAndConquer = inversionByDivideAndConquer+mid-i+1;
			}
			else a[k] = aux[i++];
		}
	}
	private boolean less(int a,int b){
		return a<b;
	}
	
	private void exch(int[] a , int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void insertionSort(int[] a){
		for(int i=1;i<a.length;i++){
			for(int j=i;j>0 && less(a[j],a[j-1]);j--){
				exch(a,j,j-1);
				inversionByInsertion++;
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int[] a = new int[100000];
		Scanner in = new Scanner(new File("IntegerArray.txt"));
		int i=0;
		while(in.hasNext()){
			a[i++] = in.nextInt();
		}
		int[] aux =a.clone();
		int[] tr = a.clone();
		InversionCountX ic = new InversionCountX();
		long startD = System.currentTimeMillis();
		ic.inversionCount(a, aux, 0, a.length-1);
		System.out.println("by divide and conquer :");
		System.out.println(" count is :"+inversionByDivideAndConquer+" time taken :"+(System.currentTimeMillis()-startD)+" mili seconds");
		
		//
		long startI = System.currentTimeMillis();
		ic.insertionSort(tr);
		System.out.println("by insertion sort:  ");
		System.out.println(" count is :"+inversionByInsertion+" time taken :"+(System.currentTimeMillis()-startI)+" mili seconds");
		
	}

}
