package org.example.system.design.document.editor.badedesign;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DocumentEditor {

    private List<String> elements = new ArrayList<>();
    private String renderedDocument = "";

    public void addText(String text) {
        elements.add(text);
    }

    public void addImage(String path) {
        elements.add(path);
    }

    public String renderDocument() {

        if (renderedDocument.isEmpty()) {

            StringBuilder stringBuilder = new StringBuilder();

            for (String e: elements) {
                if (e.length() > 4 && (e.contains(".pn") || e.contains(".jpg"))) {
                    stringBuilder.append("Image: ").append(e).append("\n");
                } else {
                    stringBuilder.append(e).append("\n");
                }
            }

            renderedDocument = stringBuilder.toString();


        }

        return renderedDocument;
    }

    public void saveInFile() throws IOException {

        Path file = Paths.get("/home/asifmd/REPO/DSA/src/main/java/org/example/system/design/document/editor/badedesign/rendered-document.txt");

        Files.writeString(file, renderedDocument);
    }

    public static void main(String[] args) throws IOException {
        DocumentEditor documentEditor = new DocumentEditor();


        documentEditor.addText("Hi this is my first line");
        documentEditor.addImage("/abc/def.jpg");
        System.out.println(documentEditor.renderDocument());
        documentEditor.saveInFile();

    }

}
