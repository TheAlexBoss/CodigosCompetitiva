package com.company;

public class codigoTIA2 {

    // Driver program to test above function
    public static void main(String[] args) {
        //char digits[] = {'1','1','7' ,'2','2', '3', '4','7','1','9','9','2','5'};
        char digits[] = {'1','1','1','1'};
        int n = digits.length;
        System.out.printf("Count is %d", countDecoding(digits, n));
    }

    // This code is contributed by Smitha Dinesh Semwal.
// Modified by Atanu Sen

    static int countDecoding(char[] digits, int n) {
        // base cases
        if (n == 0 || n == 1)
            return 1;
        if (digits[0] == '0')   //for base condition "01123" should return 0
            return 0;

        // Initialize count
        int count = 0;

        // If the last digit is not 0, then
        // last digit must add to
        // the number of words
        if (digits[n - 1] > '0')
            count = countDecoding(digits, n - 1);

        // If the last two digits form a number
        // smaller than or equal to 26,
        // then consider last two digits and recur
        if (digits[n - 2] == '1' ||
                (digits[n - 2] == '2' && digits[n - 1] < '7'))
            count += countDecoding(digits, n - 2);

        return count;
    }
}
