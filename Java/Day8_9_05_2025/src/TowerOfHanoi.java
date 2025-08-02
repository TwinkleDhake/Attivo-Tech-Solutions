public class TowerOfHanoi {
    public static void moveDisks(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("moving disk 1 from " + from + " to " + to);
            return;
        }
        moveDisks(n - 1, from, aux, to);
        System.out.println("moving disk " + n + " from " + from + " to " + to);
        moveDisks(n - 1, aux, to, from);
    }
    public static void main(String[] args) {
        int n = 3;
        moveDisks(n, 'a', 'c', 'b');
    }    
}