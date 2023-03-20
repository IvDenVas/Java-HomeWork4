import java.util.LinkedList;
import java.util.Queue;

public class task2 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        System.out.println("Начальная очередь: " + queue);
        enqueue(queue, 55);
        System.out.print("Метод enqueue: ");
        System.out.println(queue);
        System.out.print("Метод dequeue: ");
        System.out.println(dequeue(queue));
        System.out.println("Очередь после метода dequeue: " + queue);
        System.out.println("Метод first: " + first(queue));
        System.out.println("Конечная очередь: " + queue);
    }

    public static LinkedList<Integer> enqueue(Queue<Integer> queue, Integer newElement) {
        queue.add(newElement);
        return (LinkedList<Integer>) queue;
    }
    
    public static Integer dequeue(Queue<Integer> queue) {
        return (queue.poll());
    }
    
    public static Integer first(Queue<Integer> queue) {
        return (queue.peek());
    }
}
