package org.example.system.design.composite.design.pattern;

import java.util.ArrayList;
import java.util.List;

public class CompositeDesignPatternExample {
    public static void main(String[] args) {

        MyFolder root = new MyFolder("root");
        MyFolder doc = new MyFolder("doc");

        MyFile file1 = new MyFile("file1.txt", 1);
        MyFile file2 = new MyFile("file2.txt", 1);
        MyFile file3 = new MyFile("file3.txt", 1);

        root.addChild(file1);
        root.addChild(file2);
        root.addChild(doc);
        doc.addChild(file3);
        System.out.println("ls in root");
        root.ls();

        System.out.println("OpenAllOnRoot");
        root.openAll();

        System.out.println("root sie");
        System.out.println(root.getSize());

        System.out.println("doc size");
        System.out.println(doc.getSize());


        System.out.println("cd doc");
        System.out.println(root.cd("doc").getName());
    }


}

interface FileSystem {
    void ls();
    void openAll();
    int getSize();
    FileSystem cd(String name);
    String getName();
    boolean isFolder();
}

class MyFile implements FileSystem {

    private String name;
    private int size;

    MyFile(String name, int size) {
        this.name = name;
        this.size = size;
    }


    @Override
    public void ls() {
        System.out.println(getName());
    }

    @Override
    public void openAll() {
        System.out.println(getName());
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public FileSystem cd(String name) {
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isFolder() {
        return false;
    }
}

class MyFolder implements FileSystem {

    private String name;
    List<FileSystem> child;


    MyFolder(String name) {
        this.name = name;
        child = new ArrayList<>();
    }

    public void addChild(FileSystem fileSystem) {
        child.add(fileSystem);
    }

    @Override
    public void ls() {
        for (FileSystem fileSystem: child) {
            System.out.println(fileSystem.getName());
        }
    }

    @Override
    public void openAll() {
        System.out.println(getName());
        for (FileSystem fileSystem: child) {
            fileSystem.openAll();
        }
    }

    @Override
    public int getSize() {
        int total = 0;
        for (FileSystem fileSystem: child) {
            total+=fileSystem.getSize();
        }

        return total;
    }

    @Override
    public FileSystem cd(String name) {

        for (FileSystem fileSystem: child) {
            if (fileSystem.isFolder() && fileSystem.getName().equals(name)){
                return fileSystem;
            }
        }

        return null;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isFolder() {
        return true;
    }
}