package homework20;

public class TaskTwo {
    public boolean fourAndOne(boolean result, int[] array) {
        for (int element : array) {
            return element == 4 ? true : element == 1 ? true : false;
        }
        return true;
    }
}