package org.example.system.design.document.editor.better.design;

public class DocumentEditor {

    private Persistence persistence;
    private Document document;
    private String renderedDocument;

    public DocumentEditor(Persistence persistence, Document document) {
        renderedDocument = "";
        this.persistence = persistence;
        this.document = document;
    }

    public void addImage(String image) {

        document.addElement(new ImageElement(image));
    }
    public void addText(String text) {
        document.addElement(new TextElement(text));
    }
    public void addNewLine() {
        document.addElement(new NewLineElement());
    }
    public void addTab() {
        document.addElement(new TabElement());
    }

    public String renderElement(){
        if (renderedDocument.isEmpty()) {
            renderedDocument = document.renderElement();
        }

        return renderedDocument;
    }

    public void saveDocument() {
        persistence.save(renderedDocument);
    }
}
