package pack_1.task_2;


import pack_1.task_2.markup.*;

import java.util.Arrays;
import java.util.Collections;


public class TestClass {

    public static void main(String[] args) {
        Paragraph paragraph = new Paragraph(Collections.singletonList(
                new Strong(Arrays.asList(
                        new Text("1"),
                        new Strikeout(Arrays.asList(
                                new Text("2"),
                                new Emphasis(Arrays.asList(
                                        new Text("3"),
                                        new Text("4")
                                )),
                                new Text("5")
                        )),
                        new Text("6")
                ))
        ));
        paragraph.toMarkdown();
    }
}
