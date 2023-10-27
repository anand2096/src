//package DSA.journey.queue;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Stack;
//
//public class MaxFrequencyStack {
//
//    public int[] solve(int[][] mat) {
//        int maxFreq=-1;
//        int k=0;
//        int ans[]=new int[mat.length];
//        Map<Integer,Integer> map=new HashMap<>();
//        Map<Integer, Stack<Integer>> freqStack=new HashMap<>();
//        for(int i=0;i<mat.length;i++){
//
//            if(mat[i][0]==1){
//                if(map.contains(mat[i][1])){
//                    int f=map.get(mat[i][1]);
//                    if(!freqStack.contains(f+1)){
//                        Stack<Integer> s=new Stack<>();
//                        freqStack.put(f+1,s);
//
//                    }
//                    Stack<Integer> temp=freqStack.get(f+1);
//                    temp.add(mat[i][1]);
//                    freqStack.put(f+1,temp);
//                    maxFreq=Math.max(maxFreq,f+1);
//                    map.put(mat[i][1],f+1);
//                }
//                else{
//                    map.put(mat[i][1],1);
//                    if(!freqStack.contains(1)){
//                        Stack<Integer> s=new Stack<>();
//                        freqStack.put(1,s);
//                    }
//                    Stack<Integer> temp=freqStack.get(1);
//                    temp.add(mat[i][1]);
//                    freqStack.put(1,temp);
//                    maxFreq=Math.max(maxFreq,1);
//                }
//                ans[k++]=-1;
//
//            }
//            else{
//
//                Stack<Integer> temp=freqStack.get(maxFreq);
//                int poppedElement=temp.pop();
//                ans[k++]=poppedElement;
//                if(temp.isEmpty()){
//                    freqStack.remove(maxFreq);
//                    maxFreq--;
//                }
//                else{
//                    freqStack.put(maxFreq,temp);
//
//                }
//                map.put(poppedElement,map.get(poppedElement)-1);
//                if(map.get(poppedElement)==0){
//                    map.remove(poppedElement);
//                }
//            }
//        }
//
//        return ans;
//    }
//}
