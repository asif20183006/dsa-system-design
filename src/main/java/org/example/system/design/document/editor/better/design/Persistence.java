package org.example.system.design.document.editor.better.design;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface Persistence {

    public void save(String data);
}

class SaveInFile implements Persistence {

    @Override
    public void save(String data) {

        Path path = Paths.get("/home/asifmd/REPO/DSA/src/main/java/org/example/system/design/document/editor/badedesign/rendered-document.txt");

        try {
            Files.writeString(path, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class SaveInDB implements Persistence {

    @Override
    public void save(String data) {
        // TODO document need to save in DB later
    }
}
