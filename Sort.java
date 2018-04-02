package algorithms;

public class Sort{
	
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
}