package homework20;

public class TaskTwo {
    public boolean fourAndOne(int[] array) {
        int four = 0;
        int one = 0;
        for (int element : array) {
            if(element == 4){
                four++;
            }
            if(element == 1){
                one++;
            }
        }
        if(one == 0 || four == 0){
            return false;
        }
        return one + four == array.length;
    }
}
