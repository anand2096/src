package DSA.journey.combinatorics;

public class ExcelColumnTitle {

    public static void main(String[] args) {
        System.out.println(new ExcelColumnTitle().printString(943566));
    }
    private  String printString(int columnNumber)
    {
        // To store result (Excel column name)
        StringBuilder columnName = new StringBuilder();

        while (columnNumber > 0) {
            // Find remainder
            int rem = columnNumber % 26;

            // If remainder is 0, then a
            // 'Z' must be there in output
            if (rem == 0) {
                columnName.append("Z");
                columnNumber = (columnNumber / 26) - 1;
            }
            else // If remainder is non-zero
            {
                columnName.append((char)((rem - 1) + 'A'));
                columnNumber = columnNumber / 26;
            }
        }

        // Reverse the string and print result
        return  columnName.reverse().toString();
    }
    public String convertToTitle(int s) {
        StringBuilder sb=new StringBuilder();
        while(s>0){
            int rem=s%26;
            if (rem == 0) {
                sb.append('Z');
                s=(s/26)-1;
            }
            else {
                char c = (char) ('A' + rem - 1);
                sb.append(c);
                s=s/26;
            }


        }

        return sb.reverse().toString();


    }
}
