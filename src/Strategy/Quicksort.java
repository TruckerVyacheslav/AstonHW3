package Strategy;

import java.util.List;

public class Quicksort<T extends Comparable<T>> implements Sort<T>{

    @Override
    public Object sort(List<T> list) {
        quickSort(list, 0, list.size() - 1);
        return list;
    }

    private void quickSort(List<T> list, int left, int right) {
        if(left < right) {
            int middle = partition(list, left, right);

            quickSort(list, left, middle - 1);
            quickSort(list, middle + 1, right);
        }
    }

    private int partition(List<T> list, int left, int right) {
        T pivot = list.get(left);

        int i = left;
        for(int j = left + 1; j <= right; j++) {
            if(list.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i, left);

        return i;
    }

    private void swap(List<T> list, int first, int second) {
        T middle = list.get(first);
        list.set(first, list.get(second));
        list.set(second, middle);
    }
}
