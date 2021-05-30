import java.util.function.BiPredicate;
import java.util.function.Predicate;


public class CompareStrings {
    
    String CompareTwoStrings(String str1 , String str2 , BiPredicate<String,String> bipredicate){
        if(bipredicate.test(str1, str2))
            return str1;
        else
            return str2;
    }
    boolean checkString(String str,Predicate<String> predic){
        return predic.test(str);
    }
    
}
