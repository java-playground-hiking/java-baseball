package baseball.util;

import java.util.List;
import java.util.stream.Collectors;

public class BaseballUtils {

    public static List<String> splitByBlank(String number) {

        return List.of(number.split(""));
    }


    public static List<Integer> convertDataTypesIntoListData(List<String> strings) {
        return strings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
