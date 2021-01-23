package com.gp.demo06_sort;

public class Demo01_Bubble_Insert_Select_Sort {
	

	public static void bubbleSort(int[] array) {
		int length = array.length;
		for (int i = 0; i < array.length -1 ; i++) {
			for (int j = 1; j < length -i ; j++) {
				if (array[j - 1] > array[j]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	public static void insertSort(int[] array) {
		int insertNode;
		int j;
		for (int i = 1; i < array.length; i++) {
			insertNode = array[i];
			j = i - 1;
			//这里是关键点，如果比后面的大，while就跳出了
			while(j >= 0 && insertNode < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = insertNode;
		}
	}

	public static void selectSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int pos = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[pos] > array[j]) {
					pos = j;
				}
			}
			if (pos != i) {
				int temp = array[i];
				array[i] = array[pos];
				array[pos] = temp;
			}
		}
	}
    public static void selectSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int j = 0; j < array.length; j++) {
            array[j] =(int)(Math.random() * 10000);
        }
        int[] tmp = new int[array.length];
        System.arraycopy(array, 0, tmp, 0, array.length);

        //1.bubble Sort
        long start1 = System.currentTimeMillis();
            bubbleSort(tmp);
        long end1 = System.currentTimeMillis();
        System.out.println("Bubble Sort->" + (end1 - start1) + "ms\n");
        System.arraycopy(array, 0, tmp, 0, array.length);

        //2.insert Sort
        long start2 = System.currentTimeMillis();
            insertSort(tmp);
        long end2 = System.currentTimeMillis();
        System.out.println("Insert Sort->" + (end2 - start2) + "ms\n");
        System.arraycopy(array, 0, tmp, 0, array.length);

        //3.select sort
        long start3 = System.currentTimeMillis();
            selectSort(tmp);
        long end3 = System.currentTimeMillis();
        System.out.println("Select Sort->" + (end3 - start3) + "ms\n");
        System.arraycopy(array, 0, tmp, 0, array.length);

        //3.select sort
        long start4 = System.currentTimeMillis();
            selectSort2(tmp);
        long end4 = System.currentTimeMillis();
        System.out.println("Select2 Sort->" + (end4 - start4) + "ms\n");
        System.arraycopy(array, 0, tmp, 0, array.length);
    }
}
