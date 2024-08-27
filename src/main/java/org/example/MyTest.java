package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MyTest {
    /**
     * initial test data
     */
    MyTest(){
        for (char ch = 'a'; ch <= 'z'; ch++) {
            mulCharList.add((ch+"")+(ch+"")+(ch+""));
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            singleCharList.add((ch+""));
        }
    }

    private List<String> mulCharList= new ArrayList<String>();
    private List<String> singleCharList= new ArrayList<String>();
    private String inputs = "";
    private String inputsBuf = "";

    @Test
    void Test01() {
        inputs = "aabcccbbad";
        if(inputs!=null&&!"".equals(inputs)) {
            while (inputsBuf.length() != inputs.length()) {

                inputsBuf = inputs;
                mulCharList.forEach(str -> {
                    if (inputs.contains(str)) {
                        inputs = inputs.replace(str, "");
                        System.out.println("-> " + inputs);
                    }
                });
            }
        }
    }

    @Test
    void Test02() {
        inputs="abcccbad";
        if(inputs!=null&&!"".equals(inputs)){
            while (inputsBuf.length()!=inputs.length()) {

                inputsBuf = inputs;
                mulCharList.forEach(str -> {
                    if (inputs.contains(str)) {
                        String prechar = this.getPreChar(str.charAt(0) + "");
                        inputs = inputs.replace(str, prechar);
                        if (prechar != null && !"".equals(prechar)) {
                            System.out.println(String.format("-> %s, %s is replaced by %s", inputs, str, prechar));
                        }else {
                            System.out.println("-> "+inputs);
                        }
                    }
                });

            }
        }
    }

    /**
     * get previous char
     * @param thisChar
     * @return
     */
    private String  getPreChar(String thisChar){
        if(thisChar!=null&&!"".equals(thisChar)) {
            if ("a".equals(thisChar)) {
                return "";
            } else {
                return singleCharList.get(singleCharList.lastIndexOf(thisChar) - 1);
            }
        }
        return "";
    }
}
