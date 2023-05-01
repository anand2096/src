package DSA.leetCodeDaily;

public class CanPlaceFlowers {
    public static void main(String[] args) {
       int [] flowerbed = {0,0,1,0,0}; int n = 1;
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed,n));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean ans =false;
        if(flowerbed.length==1){
            if(flowerbed[0]==0 && n<=1)
                return true;
            else if(flowerbed[0]==1 && n==0)
                return true;
            else return false;

        }
//1,0,1,0,1,0,0

        for(int i=0;i<flowerbed.length;i++){
            if(i==0){
                if(flowerbed[i]==0 && flowerbed[i+1]==0){
                    flowerbed[i]=1;
                    n--;
                }
            }
            else if(i==flowerbed.length-1){
                if(flowerbed[i]==0 && flowerbed[i-1]==0){
                    flowerbed[i]=1;
                    n--;
                }
            }
            else if( (i+1)<flowerbed.length && flowerbed[i]==0 && flowerbed[i-1]==0 &&flowerbed[i+1]==0 ){
                flowerbed[i]=1;
                n--;
            }
        }
        if(n<=0){
            return true;
        }
        else return ans;

    }
}
