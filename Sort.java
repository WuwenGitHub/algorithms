package algorithms;

public class Sort{
	
	//冒泡法
	public void bubbleSort(int[] arr){
		
		for (int i = 0; i < arr.length; i++){
			
			for (int j = arr.length - 1; j > 0; j--){
				
				if (arr[j] < arr[j - 1]){
					int tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
		}
	}
	
	public void bubbleSort2(int[] arr){
		//标记 没有交换-->排序以完成
		boolean flag = true;
		
		for (int i = 0; i < arr.length && flag; i++){
			
			flag = false;
			
			for (int j = 0; j < arr.length - 1; j++){
				if (arr[j] > arr[j + 1]){
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					flag = true;
				}
			}
		}
	}
	
	//选择排序
	public void selectSort(int[] arr){
		
		for (int i = 0; i < arr.length - 1; i++){
			
			int min = i;
			
			for (int j = i + 1; j < arr.length; j++){
				if (arr[j] < arr[i])
					min = j;
			}
			
			int tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;
		}
	}
	
	//插入排序
	public void insertSort(int[] arr){
		
		for (int i = 1; i < arr.length; i++){
			
			if (arr[i] < arr[i - 1]){
				
				int tmp = arr[i];
				int j = i;
				
				for (; j > 0 && arr[j - 1] > tmp; j--){
					arr[j] = arr[j - 1];
				}
				
				arr[j] = tmp;
			}
		}
	}
	
	//希尔排序(缩小增量排序)
	public void shellSort(int[] arr){
		int i, j;
		int increment = arr.length;
		
		do{
			//增量序列  dlta[k]=2^(t-k+1)-1 (0<=k<=[log2(n+1)])
			increment = increment  / 3 + 1;
			
			for (i = increment; i < arr.length; i++){
				if (arr[i] < arr[i - increment]){
					int tmp = arr[i];
					for (j = i - increment; j >= 0 && tmp < arr[j]; j -= increment){
						arr[j + increment] = arr[j];
					}
					arr[j + increment] = tmp;
				}
			}
		}while(increment > 1);
	}
	
	//堆排序(完全二叉树)
	//实质:  按层次遍历构建二叉树并对非叶子节点处理过程
	//大顶堆: 每个节点的值都大于或等于其左右孩子的值
	//小顶堆: 每个节点的值都小于或等于其左右孩子的值
	public void heapSort(int[] arr){
		int i;
		
		//构建大顶堆
		for (i = arr.length / 2 - 1; i >= 0; i--)
			heapAdjust(arr, i, arr.length - 1);
		
		//排序
		for (i = arr.length - 1; i > 0; i--){
			swap(arr, 0, i);//将堆顶记录和当前未经排序子序列的最后一个记录交换
			heapAdjust(arr, 0, i - 1);//将arr[1..i-1]重新调整为大顶堆
		}
	}
	
	private void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	private void heapAdjust(int[] arr, int s, int m){
		int tmp, j;
		
		tmp = arr[s];
		
		for (j = 2 * s + 1; j <= m; j = j * 2 + 1){
			
			if (j < m && arr[j] < arr[j + 1])
				++j;
			
			if (tmp >= arr[j])
				break;
			
			arr[s] = arr[j];
			s = j;
		}
		arr[s] = tmp;
	}
	
	//归并排序
	public void mergeSort(int[] arr){
		MSort(arr, arr, 0, arr.length - 1);
	}
	
	private void MSort(int[] SR, int[] TR, int s, int t){
		int m = 0;
		
		int[] TR2 = new int[SR.length];
		
		if (s == t)
			TR[s] = SR[s];
		else{
			m = (s + t) / 2;
			MSort(SR, TR2, s, m);
			MSort(SR, TR2, m + 1, t);
			Merge(TR2, TR, s, m, t);
		}
	}
	
	private void Merge(int[] SR, int[] TR, int i, int m, int n){
		int j, k, l;
		
		for (j = m + 1, k = i; i <= m && j <= n; k++){
			if (SR[i] < SR[j])
				TR[k] = SR[i++];
			else
				TR[k] = SR[j++];
		}
		
		if (i <= m){
			for (l = 0; l <= m - i; l++)
				TR[k + l] = SR[i + l];
		}
		
		if (j <= n){
			for (l = 0; l <= n - j; l++)
				TR[k + l] = SR[j + l];
		}
	}
	
	//快速排序
	public void quickSort(int arr[]){
		QSort(arr, 0, arr.length - 1);
	}
	
	private void QSort(int[] arr, int low, int high){
		int pivot;
		
		if (low < high){
			pivot = Partition(arr, low, high);
			
			QSort(arr, low, pivot - 1);
			QSort(arr, pivot + 1, high);
		}
	}
	
	private int Partition(int[] arr, int low, int high){
		int pivotKey;
		
		pivotKey = arr[low];
		
		while(low < high){
			while(low < high && arr[high] >= pivotKey)
				high--;
			swap(arr, low, high);
			
			while(low < high && arr[low] <= pivotKey)
				low++;
			swap(arr, low, high);
		}
		
		return low;
	}
}