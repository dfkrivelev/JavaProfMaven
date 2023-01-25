package homework20;

/**
 * Java Prof. Homework #20
 *
 * @author Dzmitry Kryvialeu
 * @version 23.01 - 25.01
 */

public class Homework20 {
    public int[] newArray(int[] array) {
        int cursor = 0;

        if (array == null) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                cursor = i;
            }
        }

        if (cursor == 0) {
            throw new RuntimeException();
        }

        int[] newArray = new int[array.length - cursor - 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[++cursor];
        }

        return newArray;
    }
}
