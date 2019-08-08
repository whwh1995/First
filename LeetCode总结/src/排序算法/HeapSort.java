package ÅÅÐòËã·¨;

public class HeapSort {
	public static void heapsort(int[] a) {
		for(int i=a.length/2-1;i>=0;i--) {
			percDown(a,i,a.length-1);
		}
		for(int i=a.length-1;i>0;i--) {
			swap(a,0,i);
			percDown(a,0,i-1);
		}
		
	}

	private static void swap(int[] a, int i, int j) {
		 int tmp=a[i];
		 a[i]=a[j];
		 a[j]=tmp;
		
	}

	private static void percDown(int[] a, int i, int j) { //j=limit;
		int child;
		int tmp;
		for(tmp=a[i];2*i+1<=j;i=child) {
			child=leftChild(i);
			if(a[child]<a[child+1]&&child+1<=j) {
				child++;
			}
			if(a[child]>tmp) {
				a[i]=a[child];
			}else {
				break;
			}
		}
		a[i]=tmp;
		
	}
	private static int leftChild(int n) {
		return 2*n+1;
	}
	
}
