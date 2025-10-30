package Strategy;

import java.util.List;

public interface Sort<T extends Comparable<T>> {
    public Object sort(List<T> list);
}
