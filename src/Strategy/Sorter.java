package Strategy;

import java.util.List;

public class Sorter{

    private Sort sortStrategy;

    public void setSortStrategy(Sort sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public Sorter(Sort sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public Object sort(List<?> comparableList) {
        return sortStrategy.sort(comparableList);
    }

    public static Quicksort<?> quickSort(){
        return new Quicksort<>();
    }

    public static BubbleSort<?> bubbleSort(){
        return new BubbleSort<>();
    }

}