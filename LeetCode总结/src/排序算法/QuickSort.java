package ≈≈–ÚÀ„∑®;

public class QuickSort {
	public static void quickSort(int[] a) {
		if(a==null)
			return;
		quickSort(a,0,a.length-1);
	}

	private static void quickSort(int[] a, int left, int right) {
	
		/*int mid=(left+right)/2;
		if(a[mid]<a[left])
			swap(a[mid],a[left]);
		if(a[right]<a[left])
			swap(a[right],a[left]);
		if(a[right]<a[mid])
			swap(a[right],a[mid]);
		int tmp=a[mid];
		swap(a[mid],a[right-1]);*/
	if(left<right) {
		int tmp=median3(a,left,right);
		int i=left;
		int j=right-1;
		while(true) {
			while(a[++i]<tmp) {}
			while(a[--j]>tmp) {}
			if(i<j)
				swap(a,i,j);
			else
				break;
		}
		swap(a,i,right-1);
		quickSort(a,left,i-1);
		quickSort(a,i+1,right);
	}
	}

	private static void swap(int[] a,int i, int j) {
		int tmp=a[i];
			a[i]=a[j];
			a[j]=tmp;
	}
	private static int median3(int[] a,int left,int right) {
		int mid=(left+right)/2;
		if(a[mid]<a[left])
			swap(a,mid,left);
		if(a[right]<a[left])
			swap(a,right,left);
		if(a[right]<a[mid])
			swap(a,right,mid);
		swap(a,mid,right-1);
		return a[right-1];
	}
	
}
