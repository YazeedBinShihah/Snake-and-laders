import java.util.*;

public class SnakeAndLadder {

    public int snakeAndLadder(ArrayList<ArrayList<Integer>> ladders, ArrayList<ArrayList<Integer>> snakes) {
        int n = 100; // number of squares on the board
        int[] minRolls = new int[n + 1]; // initialize an array to store minimum rolls needed to reach each square
        Arrays.fill(minRolls, Integer.MAX_VALUE); // initialize all elements to a large value
        minRolls[1] = 0; // minimum rolls needed to reach the first square is 0

        Queue<Integer> queue = new LinkedList<>(); // initialize a queue to perform BFS traversal
        queue.offer(1); // add the first square to the queue

        while (!queue.isEmpty()) {
            int currPos = queue.poll(); // remove the current square from the queue

            for (int i = 1; i <= 6; i++) { // consider all possible dice rolls
                int nextPos = currPos + i; // calculate the next square based on the dice roll

                if (nextPos > n) { // if the next square is beyond the board, ignore it
                    break;
                }

                for (ArrayList<Integer> ladder : ladders) { // check if the next square has a ladder
                    if (ladder.get(0) == nextPos) { // if the ladderstarts at the next square,
                        nextPos = ladder.get(1); // move to the end of the ladder
                        break; // stop checking for ladders
                    }
                }

                for (ArrayList<Integer> snake : snakes) { // check if the next square has a snake
                    if (snake.get(0) == nextPos) { // if the snake starts at the next square,
                        nextPos = snake.get(1); // move to the end of the snake
                        break; // stop checking for snakes
                    }
                }

                if (minRolls[nextPos] > minRolls[currPos] + 1) { // if the new path is shorter than the current path
                    minRolls[nextPos] = minRolls[currPos] + 1; // update the minimum rolls needed to reach the next square
                    queue.offer(nextPos); // add the next square to the queue
                }
            }
        }

        return minRolls[n]; // return the minimum rolls needed to reach the last square
    }
}