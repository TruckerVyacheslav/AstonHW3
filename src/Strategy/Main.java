import Strategy.Sorter;

void main() {
    Sorter sorter = new Sorter(Sorter.quickSort());

    ArrayList<Integer> arr = new ArrayList<>(List.of(6,5,7,3,2,1));

    sorter.sort(arr);

    System.out.println(arr.toString());
}

