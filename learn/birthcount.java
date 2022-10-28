import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.*;

public class birthcount {
    public static void main(String[] args) throws Exception {
        //建立字串aaa
        String aaa = "1992-09-18";
        //取得日期格式
        DateFormat dateFormat = 
            new SimpleDateFormat("yyyy-MM-dd");
        //導入字串aaa轉成日期格式    
        Date birth = dateFormat.parse(aaa);
        //取得今日日期
        Date current = new Date();

        //建立BigDecimal物件
        BigDecimal birthBNum = new BigDecimal(birth.getTime());
        BigDecimal currentBNum = new BigDecimal(current.getTime());
        BigDecimal yeartimeBNum = new BigDecimal(31536000000L);
        BigDecimal age = null;
        //BigDecimal運算
        age = (currentBNum.subtract(birthBNum)).divide(yeartimeBNum, 2, RoundingMode.HALF_DOWN);

        System.out.println(age);
        
    }
}
