import java.util.Map;
import java.util.HashMap;

public class map {
    public static void main(String[] args){
        //製作HashMap
        Map<String, Integer> testMapObject = new HashMap<>();
        //放入資料
            testMapObject.put("One", 1);
            testMapObject.put("Two", 2);
            testMapObject.put("Three", 3);

            System.out.println(testMapObject);

            System.out.println("Key: " + testMapObject.keySet());

            System.out.println("Value: " + testMapObject.values());
    }
    
}