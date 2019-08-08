package 排序算法;

public class MergeSort {
	public static void mergeSort(int[] a) {
		int len=a.length;
		int[] assist =new int[len];
		mergeSort(a,assist,0,len-1);
	}

	

	private static void mergeSort(int[] a, int[] tmp, int left, int right) {
		if(left<right) {
			int mid =(left+right)/2;
			mergeSort(a,tmp,left,mid);
			mergeSort(a,tmp,mid+1,right);
			merge(a,tmp,left,mid+1,right);
		}
	}



	private  static void merge(int[] a, int[] tmp, int leftpos, int rightpos, int rightend) {
		int leftend=rightpos-1;
		int tmppos=leftpos;
		int number=rightend-leftpos+1;
		while(leftpos<=leftend&&rightpos<=rightend) {
			if(a[leftpos]<=a[rightpos])
				tmp[tmppos++]=a[leftpos++];
	
			else {
				tmp[tmppos++]=a[rightpos++];
			}
		}
		while(leftpos<=leftend) {
			tmp[tmppos++]=a[leftpos++];
		}
		while(rightpos<=rightend) {
			tmp[tmppos++]=a[rightpos++];
		}
		for(int i=0;i<number;i++,rightend--) {
			a[rightend]=tmp[rightend]; // 因为并非所有的数组都是从0位开始复制的，只有第一个数组才是。
		}
	}



	

	
	
	
}
