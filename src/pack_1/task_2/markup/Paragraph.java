package pack_1.task_2.markup;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {

    private List<Text> textList = new ArrayList<>();

    public Paragraph(Text text) {
        this.textList.add(text);
    }

    public Paragraph(List<Text> textList) {
        this.textList = textList;
    }

    public void toMarkdown(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Text text: textList){
            stringBuilder.append(text.toMarkdown());
        }
        System.out.println(stringBuilder);
    }
}
