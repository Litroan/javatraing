import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.*;

public class birthcount {
    public static void main(String[] args) throws Exception {
        //�إߦr��aaa
        String aaa = "1992-09-18";
        //���o����榡
        DateFormat dateFormat = 
            new SimpleDateFormat("yyyy-MM-dd");
        //�ɤJ�r��aaa�ন����榡    
        Date birth = dateFormat.parse(aaa);
        //���o������
        Date current = new Date();

        //�إ�BigDecimal����
        BigDecimal birthBNum = new BigDecimal(birth.getTime());
        BigDecimal currentBNum = new BigDecimal(current.getTime());
        BigDecimal yeartimeBNum = new BigDecimal(31536000000L);
        BigDecimal age = null;
        //BigDecimal�B��
        age = (currentBNum.subtract(birthBNum)).divide(yeartimeBNum, 2, RoundingMode.HALF_DOWN);

        System.out.println(age);
        
    }
}
