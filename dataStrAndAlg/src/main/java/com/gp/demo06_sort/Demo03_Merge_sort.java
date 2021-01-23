package com.gp.demo06_sort;

public class Demo03_Merge_sort {

	//merge Sort
	public static void mergeSort(int[] array) {
		int[] temp = new int[array.length];
		mergeSortImpl(array, 0, array.length - 1, temp);
	}
	public static void mergeSortImpl(int[] array, int start, int end, int[] temp) {
		if (start >= end) return;

		int mid = (start + end) / 2;
		mergeSortImpl(array, start, mid, temp);
		mergeSortImpl(array, mid + 1, end, temp);
		merge(array, start, mid, end, temp);
	}
	
	public static void merge(int[] array, int start, int mid, int end, int[] temp) {
		int left = start;
		int right = mid + 1;
		int index = start;
		while (left <= mid && right <= end) {
			if (array[left] < array[right]) {
				temp[index++] = array[left++];//这里记得是先使用再++
			} else {
				temp[index++] = array[right++];
			}
		}
		while (left <= mid) {
			temp[index++] = array[left++];
		}
		while (right <= end) {
			temp[index++] = array[right++];
		}
		for (index = start; index <= end; index++) {
			array[index]= temp[index];
		}
	}


	public static void main(String[] args) {
		int[] array = new int[10000];
		for (int j = 0; j < array.length; j++) {
			array[j] =(int)(Math.random() * 100000);
		}
		int[] tmp = new int[array.length];
		System.arraycopy(array, 0, tmp, 0, array.length);

		//1.bubble Sort
		long start1 = System.currentTimeMillis();
		Demo01_Bubble_Insert_Select_Sort.bubbleSort(tmp);
		long end1 = System.currentTimeMillis();
		System.out.println("Bubble Sort->" + (end1 - start1) + "ms\n");

		System.arraycopy(array, 0, tmp, 0, array.length);

		//2.insert Sort
		long start2 = System.currentTimeMillis();
		Demo01_Bubble_Insert_Select_Sort.insertSort(tmp);
		long end2 = System.currentTimeMillis();
		System.out.println("Insert Sort->" + (end2 - start2) + "ms\n");

		System.arraycopy(array, 0, tmp, 0, array.length);

		//3.select sort
		long start3 = System.currentTimeMillis();
		Demo01_Bubble_Insert_Select_Sort.selectSort(tmp);
		long end3 = System.currentTimeMillis();
		System.out.println("Select Sort->" + (end3 - start3) + "ms\n");

		System.arraycopy(array, 0, tmp, 0, array.length);

		//4.quick sort
		long start4 = System.currentTimeMillis();
		Demo02_Quick_Sort.quickSort(tmp);
		long end4 = System.currentTimeMillis();
		System.out.println("quick Sort->" + (end4 - start4) + "ms\n");

        System.arraycopy(array, 0, tmp, 0, array.length);

        //5.merge sort
		long start5 = System.currentTimeMillis();
			mergeSort(array);
		long end5 = System.currentTimeMillis();
		System.out.println("merge Sort->" + (end5 - start5) + "ms\n");

	}
}
