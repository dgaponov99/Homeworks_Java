package pack_1.task_2.markup;

import java.util.List;

public class Strikeout extends Mark {

    private static final String SYMBOL = "~";

    public Strikeout(List<Text> textList) {
        super(textList);
        setSYMBOL(SYMBOL);
    }

    public Strikeout(Text text) {
        super(text);
        setSYMBOL(SYMBOL);
    }
}
