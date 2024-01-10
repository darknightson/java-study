package oop.section_3_7;

public class AnotherService {

    private final FacadeVideoAnalyzer facadeVideoAnalyzer;

    public AnotherService(FacadeVideoAnalyzer facadeVideoAnalyzer) {
        this.facadeVideoAnalyzer = facadeVideoAnalyzer;
    }

    public VideoAnalystsResult doSomething() {
        return facadeVideoAnalyzer.analysis();
    }
}
