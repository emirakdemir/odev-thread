import java.util.ArrayList;
class MyThread extends Thread {
    private ArrayList<Integer> inputList;
    private ArrayList<Integer> oddNumbers;
    private ArrayList<Integer> evenNumbers;

    public MyThread(ArrayList<Integer> inputList, ArrayList<Integer> oddNumbers, ArrayList<Integer> evenNumbers) {
        this.inputList = inputList;
        this.oddNumbers = oddNumbers;
        this.evenNumbers = evenNumbers;
    }

    @Override
    public void run() {
        for (int num : inputList) {
            if (num % 2 == 0) {
                synchronized (evenNumbers) {
                    evenNumbers.add(num);
                }
            } else {
                synchronized (oddNumbers) {
                    oddNumbers.add(num);
                }
            }
        }
    }
}