package pack_1.task_2.markup;

import java.util.ArrayList;
import java.util.List;

public class Mark extends Text {

    private List<Text> textList = new ArrayList<>();
    private String SYMBOL = "";

    Mark(List<Text> textList) {
        this.textList = textList;
    }

    Mark(Text text) {
        this.textList.add(text);
    }


    void setSYMBOL(String SYMBOL) {
        this.SYMBOL = SYMBOL;
    }

    @Override
    public StringBuilder toMarkdown() {
        StringBuilder stringBuilder = new StringBuilder(SYMBOL);
        for (Text text : textList) {
            stringBuilder.append(text.toMarkdown());
        }
        stringBuilder.append(SYMBOL);
        return stringBuilder;
    }
}
