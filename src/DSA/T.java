//package DSA;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class T {
//
//    public static void main(String[] args) {
//           int ans[]=new T().circularGameLosers(5,2);
//           for(int i=0;i<ans.length;i++){
//               System.out.print(ans[i]+" ");
//           }
//    }
//
//    public int[] circularGameLosers(int n, int k) {
//
//        List<Integer> list=new ArrayList<>();
//        // int arr[]=new int[n];
//        int hash[]=new int[n+1];
//        int x=1;
//        hash[1]=1;
//        int i=1;
//        while(true){
//            int newIndex=i+(x*k);
//            x++;
//            if(newIndex%(n)!=0)
//            {hash[(newIndex)%(n)]++;
//                if (hash[(newIndex)%(a)] == 2) {
//                    break;
//                }
//
//                i=newIndex%(n+1);
//            }
//            else{
//                hash[(newIndex)]++;
//                if (hash[(newIndex)] == 2) {
//                    break;
//                }
//
//                i=newIndex;
//            }
//        }
//
//        for(int j=1;j<=n;j++){
//            if(hash[j]==0){
//                list.add(j);
//            }
//        }
//        int ansArr[]=new int[list.size()];
//        for(int j=0;j<list.size();j++){
//            ansArr[j]=list.get(j);
//        }
//        return ansArr;
//
//
//    }
//}
