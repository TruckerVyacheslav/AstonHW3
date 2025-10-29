package Strategy;

import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public Object sort(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) >= 0) {
                    swap(list, i, j);
                }
            }
        }

        return list;
    }

    private void swap(List<T> list, int first, int second) {
        T middle = list.get(first);
        list.set(first, list.get(second));
        list.set(second, middle);
    }
}
