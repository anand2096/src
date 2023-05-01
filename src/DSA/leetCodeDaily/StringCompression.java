package DSA.leetCodeDaily;

public class StringCompression {

    public static void main(String[] args) {
        String s = "aaabbaa";
        System.out.println(new StringCompression().compress(s.toCharArray()));
    }


    /**
     * OPTIMIZED
     *
     * int compress(vector<char>& chars) {
     * 	int i = 0;
     * 	for(int j = 1, count = 1; j <= chars.size(); j++, count++) {
     * 		if(j == chars.size() || chars[j] != chars[j - 1]) {
     * 			chars[i++] = chars[j - 1];
     * 			if(count >= 2)
     * 				for(char digit : to_string(count))
     * 					chars[i++] = digit;
     * 			count = 0;
     *                }* 	}
     * 	return i;
     * }
     *
     *
     *

     */
    public int compress(char[] chars) {
        int ans = 0;
        int count = 1;
        char c = chars[0];
        int start = 0;
        int i;
        for (i = 1; i < chars.length; i++) {
            if (chars[i] == c) {
                count++;
            } else {
                if (count == 1) {
                    start = i = 1;
                    count = 1;
                    c = chars[i + 1];
                    continue;
                } else if (count>=2) {
                    // int j=i-3;
                    int j = i - 1;
                    String counter=count+"";
                    for(int k=start+2;k<=j;)
                    while (j > start + 1) {
                        chars[j] = '.';
                        j--;
                    }
                    chars[start + 1] = (char) (count + '0');
                    chars[start] = c;
                } else if (count > 10) {
                    int j = i - 1;
                    int num = count % 10;
                    int carry = count / 10;

                    while (j > start + 2) {
                        chars[j] = '.';
                        j--;
                    }

                    chars[start + 2] = (char) (num + '0');
                    chars[start + 1] = (char) (carry + '0');
                    chars[start] = c;
                }
                start = i;
                count = 1;
                c = chars[i];

            }
        }

        if (count != 1 && count < 10) {
            int j = i - 1;
            while (j > start + 1) {
                chars[j] = '.';
                j--;
            }
            chars[start + 1] = (char) (count + '0');
            chars[start] = c;
        } else if (count > 10) {
            int j = i - 1;
            int num = count % 10;
            int carry = count / 10;
            while (j > start + 2) {
                chars[j] = '.';
                j--;
            }

            chars[start + 2] = (char) (num + '0');
            chars[start + 1] = (char) (carry + '0');
            chars[start] = c;
        }

        for (int t = 0; t < chars.length; t++) {
            if (chars[t] != '.') {
                ans++;
            } else {
                break;
            }
        }


        return ans;
    }
}
