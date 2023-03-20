import java.util.LinkedList;

public class task1 {
    public static void main(String[] args) {
        LinkedList<Integer> lklist = new LinkedList<>();
        lklist.add(1);
        lklist.add(2);
        lklist.add(3);
        lklist.add(4);
        lklist.add(5);
        lklist.add(6);

        System.out.println("Начальный LinkedList: " + lklist);
        System.out.println("После метода: " + reverse(lklist));
    }

    public static LinkedList<Integer> reverse(LinkedList<Integer> a) {
        LinkedList<Integer> result = new LinkedList<>();
        int count = a.size();
        for (int i = 0; i < count; i++) {
            result.addFirst(a.getFirst());
            a.removeFirst();
        }
        return result;
    }
}