package org.example.system.design.template.design.pattern;

public class TemplateDesignPattern {

    public static void main(String[] args) {

        ModelTrainer neuralModelTrainer = new NeuralModelTrainer();
        System.out.println("NeuralModelTrainer Training....");
        neuralModelTrainer.trainPipeLine("test.scv");

        ModelTrainer decisionTreeModelTrainer = new DecisionTreeModelTrainer();

        System.out.println("\nDecisionTreeModelTrainer Training....");
        decisionTreeModelTrainer.trainPipeLine("test.img");

    }
}

interface ModelTrainer {
    default void loadData(String data) {
        System.out.println("[Common] Loading data set from : " + data);
    }

    default void preprocessData() {
        System.out.println("[Common] splitting into train/test data for normalizing");
    }

    void trainModel();
    void evaluateModel();

    default void saveData() {
        System.out.println("[Common] saving data..");
    }

    default void trainPipeLine(String data) {
        loadData(data);
        preprocessData();
        trainModel();
        evaluateModel();
        saveData();
    }
}

class NeuralModelTrainer implements ModelTrainer {

    @Override
    public void trainModel() {
        System.out.println("[NeuralModelTrainer] training the data");
    }

    @Override
    public void evaluateModel() {
        System.out.println("[NeuralModelTrainer] evaluating the data");
    }

    @Override
    public void saveData() {
        System.out.println("[NeuralModelTrainer] saving data..");
    }
}

class DecisionTreeModelTrainer implements ModelTrainer {

    @Override
    public void trainModel() {
        System.out.println("[DecisionTreeModelTrainer] training the data");
    }

    @Override
    public void evaluateModel() {
        System.out.println("[DecisionTreeModelTrainer] evaluating the data");
    }

    @Override
    public void loadData(String data) {
        System.out.println("[DecisionTreeModelTrainer] Loading data set from : " + data);
    }
}