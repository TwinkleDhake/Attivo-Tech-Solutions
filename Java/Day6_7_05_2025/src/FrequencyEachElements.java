// Q3. Find the Frequency of Each Element
public class FrequencyEachElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4};
        int[] freq = new int[arr.length];
        int callon = -1;
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            if (freq[i] == callon)
                continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    freq[j] = callon;
                }
            }
            freq[i] = count;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != callon)
                System.out.println("Element " + arr[i] + ": " + freq[i] + " times");
        }
    }
}