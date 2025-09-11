package org.example.system.design.document.editor.better.design;

public class Client {

    public static void main(String[] args) {
        Document document = new Document();
        Persistence saveInFile = new SaveInFile();

        DocumentEditor editor = new DocumentEditor(saveInFile, document);

        editor.addText("Hi this is my text");
        editor.addNewLine();
        editor.addImage("my-image.jpg");
        editor.addNewLine();
        editor.addText("bye");

        System.out.println(editor.renderElement());

        editor.saveDocument();

    }
}
