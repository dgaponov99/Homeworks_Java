package pack_1.task_2.markup;

import java.util.List;

public class Strong extends Mark {

    private static final String SYMBOL = "__";

    public Strong(List<Text> textList) {
        super(textList);
        setSYMBOL(SYMBOL);
    }

    public Strong(Text text) {
        super(text);
        setSYMBOL(SYMBOL);
    }
}
