package org.example.system.design.proxy.design.pattern;

public class ProxyDesignPattern {
    public static void main(String[] args) {

        ImageProxy imageProxy = new ImageProxy();
        imageProxy.disPlay("my.img");

    }
}

interface  IDisplay {
    void disPlay(String path);
}

class ImageDisplay implements IDisplay {

    public ImageDisplay(String path) {
        System.out.println("Loading image: " + path);
    }

    @Override
    public void disPlay(String path) {
        System.out.println("Image Displayed: " + path);
    }
}


class ImageProxy  implements IDisplay {

    ImageDisplay imageDisplay;
    ImageProxy() {
        imageDisplay = null;
    }


    @Override
    public void disPlay(String path) {
        if (imageDisplay == null) {
            imageDisplay = new ImageDisplay(path);
        }

        imageDisplay.disPlay(path);
    }
}
