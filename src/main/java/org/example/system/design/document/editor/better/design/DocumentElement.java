package org.example.system.design.document.editor.better.design;

public interface DocumentElement {
    public String render();
}

class TextElement implements DocumentElement {

    String txt;

    public TextElement(String txt) {
        this.txt = txt;
    }

    @Override
    public String render() {
        return txt;
    }
}

class ImageElement implements DocumentElement {


    private String imgPath;

    public ImageElement(String imgPath) {
        this.imgPath = imgPath;
    }


    @Override
    public String render() {
        return "Image: " + imgPath;
    }
}

class NewLineElement implements DocumentElement {

    @Override
    public String render() {
        return "\n";
    }
}

class TabElement implements DocumentElement {

    @Override
    public String render() {
        return "\t";
    }
}