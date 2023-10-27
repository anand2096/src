package DSA.LRUCache;

public class LRUCacheStart {

    public static void main(String[] args) {
//"get","put","get","put","put","get","get"]
//,[2],[2,6],[1],[1,5],[1,2],[1],[2]]


//        Output
//                [null,-1,null,-1,null,null,2,-1]
//        Expected
//                [null,-1,null,-1,null,null,2,6]
        LRUCache lruCache=new LRUCache(2);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache);
        lruCache.set(2,6);
        System.out.println(lruCache);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache);

        lruCache.set(1,5);
        System.out.println(lruCache);
        lruCache.set(1,2);
        System.out.println(lruCache);
        System.out.println(  lruCache.get(1));
        System.out.println(lruCache);
        System.out.println(  lruCache.get(2));
        System.out.println(lruCache);




    }
}
