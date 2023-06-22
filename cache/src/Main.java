import cache.Cache;
import factories.CacheFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println(isValid("ababc"));
        System.out.println(isValid("aabbccab"));
        System.out.println(isValid("aaabbbv"));

    }

    static boolean isValid(String s){
        if(s == null || s.length()<=1) return false;
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        for(char c: s.toCharArray()){
            freq[c-'a']--;
            if(isSame(freq)) return true;
            freq[c-'a']++;
        }
        return false;
    }

    static boolean isSame(int[] freq){
        int count=0;
        for(int f:freq){
            if(f==0) continue;
            if(count == 0) count=f;
            if(f!=count) return false;
        }
        return true;
    }
}