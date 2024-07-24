package params.source;

import java.util.Arrays;
import java.util.List;

public class ExternalParamsProvider {

    static List<String> veggieProvider() {
        return Arrays.asList("beans", "bell pepper");
    }
}
