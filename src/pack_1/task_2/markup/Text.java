package pack_1.task_2.markup;

public class Text {
    private StringBuilder stringBuilder;

    Text() {
    }

    public Text(String text) {
        this.stringBuilder = new StringBuilder(text);
    }


    public StringBuilder toMarkdown() {
        return stringBuilder;
    }
}
