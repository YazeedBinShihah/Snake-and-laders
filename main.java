import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        SnakeAndLadder solver = new SnakeAndLadder();

  
        ArrayList<ArrayList<Integer>> Ladder1 = readArrayFromFile("Ladder1.txt");
        ArrayList<ArrayList<Integer>> Snake1 = readArrayFromFile("Snake1.txt");
        int result1 = solver.snakeAndLadder(Ladder1, Snake1);
        System.out.println("Example 1 \n" + Ladder1 + "\n" + Snake1); 
        System.out.println("Result = " + result1); 

        System.out.println("-----------------------------");


        ArrayList<ArrayList<Integer>> Ladder2 = readArrayFromFile("Ladder2.txt");
        ArrayList<ArrayList<Integer>> Snake2 = readArrayFromFile("Snake2.txt");
        int result2 = solver.snakeAndLadder(Ladder2, Snake2);
        System.out.println("Example 2 \n" + Ladder2 + "\n" + Snake2); 
        System.out.println("Result = " + result2); 
    }

    public static ArrayList<ArrayList<Integer>> readArrayFromFile(String fileName) throws FileNotFoundException {
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            ArrayList<Integer> row = new ArrayList<>();
            for (String s : line) {
                row.add(Integer.parseInt(s));
            }
            array.add(row);
        }
        scanner.close();
        return array;
    }
}