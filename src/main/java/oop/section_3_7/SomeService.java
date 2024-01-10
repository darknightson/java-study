package oop.section_3_7;

public class SomeService {

    private final FacadeVideoAnalyzer facadeVideoAnalyzer;

    public SomeService(FacadeVideoAnalyzer facadeVideoAnalyzer) {
        this.facadeVideoAnalyzer = facadeVideoAnalyzer;
    }

    public VideoAnalystsResult doSomething() {
        return facadeVideoAnalyzer.analysis();
    }
}
