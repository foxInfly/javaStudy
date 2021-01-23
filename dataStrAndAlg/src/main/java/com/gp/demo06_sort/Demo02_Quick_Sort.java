package com.gp.demo06_sort;

public class Demo02_Quick_Sort {
	
	public static void quickSort(int[] array) {
		sort(array, 0, array.length - 1);
	}

    /**
     * 快速排序
     * @param array 目标数组
     * @param start 排序起始实下标
     * @param end 排序终止下标
     */
	public static void sort(int[] array, int start, int end) {
		if (start >= end)  return;

		int pivot = array[start];//作为轴的节点
		int left = start;
		int right = end;
		while (left <= right) {
			while (left <= right && pivot > array[left] ) {
				left++;
			}
			while (left <= right && pivot < array[right]) {
				right--;
			}
			if (left <= right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
		sort(array, start, right);
		sort(array, left, end);
	}

	public static void list(int[] nums){
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[10000];
        for (int j = 0; j < array.length; j++) {
            array[j] =(int)(Math.random() * 100000);
        }
        int[] tmp = new int[array.length];
        System.arraycopy(array, 0, tmp, 0, array.length);
//        list(tmp);

        //1.bubble Sort
        long start1 = System.currentTimeMillis();
        Demo01_Bubble_Insert_Select_Sort.bubbleSort(tmp);
        long end1 = System.currentTimeMillis();
        System.out.println("Bubble Sort->" + (end1 - start1) + "ms\n");
//        list(tmp);
//        System.out.println();

        System.arraycopy(array, 0, tmp, 0, array.length);
//        list(tmp);

        //2.insert Sort
        long start2 = System.currentTimeMillis();
        Demo01_Bubble_Insert_Select_Sort.insertSort(tmp);
        long end2 = System.currentTimeMillis();
        System.out.println("Insert Sort->" + (end2 - start2) + "ms\n");
//        list(tmp);
//        System.out.println();

        System.arraycopy(array, 0, tmp, 0, array.length);
//        list(tmp);

        //3.select sort
        long start3 = System.currentTimeMillis();
        Demo01_Bubble_Insert_Select_Sort.selectSort(tmp);
        long end3 = System.currentTimeMillis();
        System.out.println("Select Sort->" + (end3 - start3) + "ms\n");
//        list(tmp);
//        System.out.println();

        System.arraycopy(array, 0, tmp, 0, array.length);
//        list(tmp);

        //4.quick sort
        long start4 = System.currentTimeMillis();
            quickSort(tmp);
        long end4 = System.currentTimeMillis();
        System.out.println("quick Sort->" + (end4 - start4) + "ms\n");
//        list(tmp);
//        System.out.println();
    }
}
