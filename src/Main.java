import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            numbers.add(i);
        }

        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        int chunkSize = numbers.size() / 4;

        ArrayList<MyThread> threads = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i + 1) * chunkSize;
            ArrayList<Integer> subList = new ArrayList<>(numbers.subList(startIndex, endIndex));

            MyThread thread = new MyThread(subList, oddNumbers, evenNumbers);
            threads.add(thread);
            thread.start();
        }

        // wait for all threads to finish
        for (MyThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // results
        System.out.println("Odd Numbers:");
        for (int num : oddNumbers) {
            System.out.print(num + " ");
        }

        System.out.println("\nEven Numbers:");
        for (int num : evenNumbers) {
            System.out.print(num + " ");
        }
    }
}