package org.example.system.design.document.editor.better.design;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private List<DocumentElement> elements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        elements.add(element);
    }

    public String renderElement() {
        StringBuilder result = new StringBuilder();
        for (DocumentElement element: elements) {
            result.append(element.render());
        }

        return result.toString();
    }

}
