package DSA.Arrays;
class Result2
{


    public static String rearrangeWord(String word){

        StringBuilder sb = new StringBuilder(word);
        boolean is = nextPermutation(sb);

        if(is == false)
            return "";
        else
            return sb.toString();



    }

    static void swap(StringBuilder sb,int l,int r)
    {
        char temp = sb.charAt(l);
        sb.setCharAt(l,sb.charAt(r));
        sb.setCharAt(r,temp);
    }

    static void reverse(StringBuilder sb,int l,int r)
    {
        while(l < r)
        {
            swap(sb,l,r);
            l++;
            r--;
        }
    }


    static int binarySearch(StringBuilder sb,int l,int r,char val)
    {
        int index = -1;

        while (l <= r)
        {
            int mid = (l+r)/2;
            if (sb.charAt(mid) <= val)
            {
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
                if (index == -1 || sb.charAt(index) >= sb.charAt(mid))
                    index = mid;
            }
        }
        return index;
    }


    static boolean nextPermutation(StringBuilder sb)
    {
        int len = sb.length();
        int i = len-2;

        while (i >= 0 && sb.charAt(i) >= sb.charAt(i+1))
            i--;

        if (i < 0)
            return false;
        else
        {
            int index = binarySearch(sb,i+1,len-1,sb.charAt(i));
            swap(sb,i,index);
            reverse(sb,i+1,len-1);
            return true;
        }
    }


}