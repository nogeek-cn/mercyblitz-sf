import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestB {

}


class OnlyOne {

    public static Map<String, Map<String, List<OnlyOne>>> generator() {
        List<OnlyOne> onlyOneList1 = Arrays.asList(new OnlyOne().setName("aa"),
                new OnlyOne().setName("bb"),
                new OnlyOne().setName("aa"));


        Map<String, List<OnlyOne>> onlyOneListList =
                Map.of("b", onlyOneList1);

        Map<String, Map<String, List<OnlyOne>>> stringMapMap = Map.of("a", onlyOneListList);

        return stringMapMap;
    }

    private String name;

    public String getName() {
        return name;
    }

    public OnlyOne setName(String name) {
        this.name = name;
        return this;
    }
}

