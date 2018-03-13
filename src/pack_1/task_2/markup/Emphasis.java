package pack_1.task_2.markup;

import java.util.List;

public class Emphasis extends Mark {

    private static final String SYMBOL = "*";

    public Emphasis(List<Text> textList) {
        super(textList);
        setSYMBOL(SYMBOL);
    }

    public Emphasis(Text text) {
        super(text);
        setSYMBOL(SYMBOL);
    }
}
