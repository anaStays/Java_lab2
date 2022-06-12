import java.lang.String;
import java.util.Queue;
import java.util.ArrayList;
import java.util.regex.*;

class doublePairImpl{
    public doublePairImpl(double key, double first, double second){
        this.key = key;
        this.first = first;
        this.second = second;
    }

    double key;
    double first;
    double second;
}



public class ParseProcessor {
    private static String[] operatorsOrder = {"*", "/", "+", "-"};
    private static char[] checkOperators = {'-', '+', '*', '/'};
    private static Queue<String> qOperators;
    private static Queue<doublePairImpl> qDigitsOrder;

    public static void Parse(String expression){
        if(isValid(expression)){
            String res = "";
                Pattern bracersExpression = Pattern.compile("\\([\\d+].+[\\d+]\\)"); //"\\([\\d+][+|-|*|/][\\d+]\\)"
                Matcher matchedBraceExpression = bracersExpression.matcher(expression);
                if(matchedBraceExpression.find()) {
                    res += matchedBraceExpression.group();
                    char sign = findSign(res);
                    if(sign == '0'){
                        System.out.println("Error sign in part: " + res);
                        return;
                    }
                    System.out.println(res);
                }
                else{
                    System.out.println("Error can't find any matches in: " + expression);
                }
        }
    }

    public static boolean isValid(String expression){
        return true;
    }

    private static char findSign(String expression){
        for(int i = 0; i < expression.length(); ++i){
            for(int j = 0; j < 4; ++j){
                if(expression.charAt(i) == checkOperators[j]){
                    return expression.charAt(i);
                }
            }
        }

        return '0';
    }

    private static int skipSpaces(int i, String expression){
        while(Character.isWhitespace(expression.charAt(i))){
            ++i;
        }

        return i;
    }
}
