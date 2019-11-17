package farm_manager;

import org.apache.commons.lang3.RandomStringUtils;

public class idGenerator {
//        all possible unicode random characters
//        String shortId = RandomStringUtils.random(8);
        //Please keep in mind, that it will contain all possible characters which is neither URL nor human friendly.
        //So check out other methods too:
        // HEX: 0-9, a-f. For example: 6587fddb, c0f182c1
//        shortId = RandomStringUtils.random(8, "0123456789abcdef"); 
        // a-z, A-Z. For example: eRkgbzeF, MFcWSksx
//        shortId = RandomStringUtils.randomAlphabetic(8); 
        // 0-9. For example: 76091014, 03771122
//        shortId = RandomStringUtils.randomNumeric(8); 
        // a-z, A-Z, 0-9. For example: WRMcpIk7, s57JwCVA
//        shortId = RandomStringUtils.randomAlphanumeric(8);
        public static void main(String [] args){
            String shortId = RandomStringUtils.randomAlphanumeric(17).toUpperCase();
            System.out.println(shortId);
        }
}
