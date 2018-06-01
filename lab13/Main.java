import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean isTrue;
        System.out.print("Enter number of array elements: ");
        int size = input.nextInt();
        int array[] = new int[size], max = array[0], decision, sum = 0, find, temp=0, z = 0;

        System.out.print("Insert array elements: ");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }

        do {
            System.out.println("Press 1 for parallelised execution/Press 2 for typical execution/Press 3 to compare times of executions");
            decision = input.nextInt();
            if(decision == 1) {

                System.out.print("Enter element that you would like to find: ");
                find = input.nextInt();

                for (int i = 0; i < array.length; i++)
                {
                    if (find == array[i]){
                        System.out.println("Element was found");
                        break;
                    }
                }

                long startTime = System.currentTimeMillis();

                for (int a = 0; a < array.length; a++) {
                    if (array[a] > max)
                        max = array[a];
                }

                delayForSecond();

                for( int num : array) {
                    sum = sum + num;
                }
                System.out.println("Sum of elements of array: " + sum);

                System.out.print("Sorted Array: ");
                Arrays.parallelSort(array);
                for (int i : array)
                    System.out.print(i + " ");

                System.out.println();

                delayForSecond();

                System.out.print("Prefix: ");
                Arrays.parallelPrefix(array, (x, y) -> x * y);
                for (int a : array)
                    System.out.print(a + " ");

                delayForSecond();

                System.out.println();
                System.out.println("Maximal value: " + max);

                delayForSecond();

                long timeSpent = System.currentTimeMillis() - startTime;
                System.out.println("Programme executed for " + timeSpent / 1000 + " seconds");
                isTrue = true;
            }
            else if (decision == 2){
                System.out.print("Enter element that you would like to find: ");
                find = input.nextInt();

                for (int i = 0; i < array.length; i++)
                {
                    if (find == array[i]){
                        System.out.println("Element was found");
                        break;
                    }
                }

                long startTime = System.currentTimeMillis();

                for (int a = 0; a < array.length; a++) {
                    if (array[a] > max)
                        max = array[a];
                }

                delayForSecond();

                for( int num : array) {
                    sum = sum + num;
                }
                System.out.println("Sum of elements of array: " + sum);

                delayForSecond();

                System.out.println("Sorted array: ");
                for (int i = 0; i < array.length; i++) {
                    for (int j = 1; j < (array.length - i); j++) {

                        if (array[j - 1] > array[j]) {
                            temp = array[j - 1];
                            array[j - 1] = array[j];
                            array[j] = temp;
                        }

                    }
                }

                for(int a = 0; a < array.length; a++)
                    System.out.print(array[a] + " ");
                System.out.println();

                delayForSecond();

                System.out.print("Prefix: ");
                    System.out.print(array[z] + " ");
                    do{
                        array[z] = array[z] * array[z + 1];
                        System.out.print(array[z] + " ");
                        z++;
                    }while((z+1) != array.length);

                    System.out.println();
                delayForSecond();
                long timeSpent = System.currentTimeMillis() - startTime;
                System.out.println("Programme executed for " + timeSpent / 1000 + " seconds");
                isTrue = true;
            }
            else if(decision == 3){
                long startTime1 = System.currentTimeMillis();

                for (int a = 0; a < array.length; a++) {
                    if (array[a] > max)
                        max = array[a];
                }

                for( int num : array) {
                    sum = sum + num;
                }

                Arrays.parallelSort(array);

                Arrays.parallelPrefix(array, (x, y) -> x * y);

                long timeSpent1 = System.currentTimeMillis() - startTime1;
                long startTime2 = System.currentTimeMillis();

                for (int a = 0; a < array.length; a++) {
                    if (array[a] > max)
                        max = array[a];
                }

                for( int num : array) {
                    sum = sum + num;
                }

                for (int i = 0; i < array.length; i++) {
                    for (int j = 1; j < (array.length - i); j++) {

                        if (array[j - 1] > array[j]) {
                            temp = array[j - 1];
                            array[j - 1] = array[j];
                            array[j] = temp;
                        }

                    }
                }

                do{
                    array[z] = array[z] * array[z + 1];
                    z++;
                }while((z+1) != array.length);

                long timeSpent2 = System.currentTimeMillis() - startTime2;
                System.out.println("Difference in time is " + (timeSpent1 - timeSpent2) + " milliseconds");
                isTrue = true;
            }
            else{
                System.out.println("Such command is unsupported!");
                isTrue = false;
            }
        }while (!isTrue);
    }

    private static void delayForSecond() {
        try {
            Thread.sleep(1000);
        } catch (java.lang.InterruptedException iex) {
            System.out.println(iex);
        }
    }
}
