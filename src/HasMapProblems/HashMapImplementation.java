package HasMapProblems;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplementation {
    static class HashMap<K,V>{
        private class Node{

            K key;
            V value;

            public Node(K key , V value){
                this.key = key;
                this.value = value;
            }

        }
        private  int n;
        private  int N;
        private LinkedList<Node> buckets [];
    public HashMap(){
        this.N = 4;
        this.buckets = new LinkedList[4];
        for(int i = 0 ; i<4 ; i++){
            this.buckets[i] = new LinkedList<>();
        }
    }
    private  int hasFunction(K key){
        int bi = key.hashCode();
        return Math.abs(bi) % N ;
    }
    private int searchINLL(K key , int bi){
        LinkedList<Node> nodes = buckets[bi];
        for(int i = 0  ; i<nodes.size() ; i++)
        {
            if(nodes.get(i).key == key){
                return i;
            }
        }
        return  -1;
    }
    private void rehashing(){
     LinkedList<Node> oldbucket[] = buckets;
     buckets = new LinkedList[N*2];
     for(int i = 0; i<buckets.length ; i++)
     {
         buckets[i] = new LinkedList<>();
     }

     for (int i = 0 ; i<buckets.length ; i++){
         LinkedList<Node> lL = buckets[i];
         for (int j = 0 ; j<lL.size() ; i++){
             Node node = lL.get(j);
             put(node.key , node.value);
         }

     }

    }
    public void put(K key,V value){
        int bi = hasFunction(key);
        int di = searchINLL(key , bi);
        if(di == -1){
            buckets[bi].add(new Node(key, value));
            n++;
        }else {
            Node data = buckets[bi].get(di);
            data.value = value;
        }
        double lamba = (double) n/N;
        if(lamba >2.0){
            rehashing();
        }
    }

        public ArrayList KeySet(K key){
        ArrayList<K> arrayList = new ArrayList<>();
         for(int i = 0 ; i<buckets.length ; i++){
             LinkedList<Node> lL = buckets[i];
             for (int j = 0 ; j<lL.size() ; j++){
                 Node node = lL.get(j);
                 arrayList.add(node.key);
             }
         }
         return arrayList;
        }
        public Boolean containsKey(K key){
            int bi = hasFunction(key);
            int di = searchINLL(key , bi);
            if(di == -1){
                return null;
            }else {
                return true;
            }
        }

    public V get(K key){
        int bi = hasFunction(key);
        int di = searchINLL(key , bi);
        if(di == -1){
            return null;
        }else {
            Node data = buckets[bi].get(di);
            return data.value;
        }
    }
        public V remove(K key){
            int bi = hasFunction(key);
            int di = searchINLL(key , bi);
            if(di == -1){
                return null;
            }else {
                Node data = buckets[bi].remove(di);
                return data.value;
            }
        }


    }

    public static void main(String[] args) {

        HashMap<String , String> hashMap = new HashMap<>();
        hashMap.put("H" , "Haseeb");
        hashMap.get("H");
        System.out.println(hashMap);


    }
}
