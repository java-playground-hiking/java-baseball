package calculator.utils;

public class StringExpression {

    /**
     * 문자열 수식을 배열로 변환
     * @param mathExpression 문자열 수식
     * @return 문자열 수식을 공백을 기준으로 `split` 한 배열 반환 값
     */
    public static String[] convertExpressionArraysByBlank(String mathExpression) {
        for (int i = 1; i < mathExpression.length(); i += 2) {
            char nextChar = mathExpression.charAt(i);

            if (nextChar != ' ') {
                throw new IllegalArgumentException("Expression must be seperated by a space");
            }
        }

        return mathExpression.split(" ");
    }

    /**
     * 문자로 이루어진 데이터를 받아 숫자 여부 확인
     * @param string 문자열 데이터
     * @return boolean - true: 숫자, false: 문자
     */
    public static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
