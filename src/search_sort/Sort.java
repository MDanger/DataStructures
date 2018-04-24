package search_sort;

public class Sort <T extends Comparable<T>> {

    public static <T extends Comparable<T>> void selectionSort(T[] data){
        int min;
        T temp;

        for (int i = 0; i < data.length-1; i++){
            min = i;
            for (int j = i+1; j < data.length; j++){
                if(data[j].compareTo(data[min])<0) min = j;
            }
            swap(data, min, i);
        }
    }
    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2){
        T temp = data[index1];
        data[index1]= data[index2];
        data[index2]=temp;
    }

    public static <T extends Comparable<T>> void insertionSort(T[] data){
        for (int i = 1; i < data.length; i++){
            T key = data[i];
            int position = i;
            while(position>0 && data[position-1].compareTo(key)>0){
                data[position] = data[position-1];
                position--;
            }
            data[position] = key;
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] data){
        int pos, scan;
        T temp;
        for (pos = data.length-1; pos >= 0; pos--){
            for (scan = 0; scan <= pos-1; scan++){
                if (data[scan].compareTo(data[scan+1])>0) swap(data, scan, scan+1);
            }
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] data){
        quickSort(data, 0, data.length-1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max){
        if(min < max){
            int partitionIndex = partition(data, min, max);
            quickSort(data, min, partitionIndex-1);
            quickSort(data, partitionIndex+1, max);
        }
    }
    private static <T extends Comparable<T>> int partition(T[] data, int min, int max){
        T partitionElement;
        int left, right;
        int middle = (min + max)/2;

        partitionElement = data[middle];

        swap(data, middle, min);
        left = min;
        right = max;

        while(left<right){
            while(left < right && data[left].compareTo(partitionElement)<=0){
                left++;
            }
            while(data[right].compareTo(partitionElement)>0){
                right--;
            }
            if (left<right) swap(data, left, right);
        }
        swap(data, min, right);
        return right;
    }

    public static <T extends Comparable<T>> void mergeSort(T[] data){
        mergeSort(data, 0, data.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] data, int min, int max){
        if (min < max){
            int mid = (min + max) / 2;
            mergeSort(data, min, mid);
            mergeSort(data, mid+1, max);
            merge(data, min, mid, max);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] data, int first, int mid, int last){
        T[] temp = (T[]) (new Comparable[data.length]);
        int first1 = first, last1 = mid;
        int first2 = mid+1, last2 = last;
        int index = first1;

        while (first1 <= last1 && first2 <= last2){
            if (data[first1].compareTo(data[first2]) <0){
                temp[index] = data[first1];
                first1++;
            } else {
                temp[index] = data[first2];
                first2++;
            }
            index++;
        }
        while(first1 <= last1){
            temp[index] = data[first1];
            first1++;
            index++;
        }

        while (first2 <= last2){
            temp[index] = data[first2];
            first2++;
            index++;
        }

        for (index = first; index <= last; index++){
            data[index] = temp[index];
        }
    }


}
