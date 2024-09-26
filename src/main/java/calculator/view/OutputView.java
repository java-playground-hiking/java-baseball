package calculator.view;

public class OutputView {
    private static final String OUTPUT_STRING_MESSAGE = "계산결과 입니다: ";

    public OutputView() {
    }

    public void printCalculationResult(int calculationResult) {
        System.out.println(OUTPUT_STRING_MESSAGE + calculationResult);
    }
}
