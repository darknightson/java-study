package oop.section_3_7;

public class FacadeVideoAnalyzer {

    private final FileDownloader fileDownloader;
    private final FileEncoding fileEncoding;
    private final VideoFeatureExtractor videoFeatureExtractor;
    private final VideoAnalyzer videoAnalyzer;
    private final FeatureRepository featureRepository;

    public FacadeVideoAnalyzer(FileDownloader fileDownloader, FileEncoding fileEncoding, VideoFeatureExtractor videoFeatureExtractor, VideoAnalyzer videoAnalyzer, FeatureRepository featureRepository) {
        this.fileDownloader = fileDownloader;
        this.fileEncoding = fileEncoding;
        this.videoFeatureExtractor = videoFeatureExtractor;
        this.videoAnalyzer = videoAnalyzer;
        this.featureRepository = featureRepository;
    }

    public VideoAnalystsResult analysis() {
        String filePath = fileDownloader.download(); // 동영상 다운로드
        String encodedFilePath = fileEncoding.encoding(filePath); // 동영상 인코딩
        VideoFeautre videoFeautre = videoFeatureExtractor.extract(encodedFilePath); // 동영상 정보 추출
        VideoAnalystsResult videoAnalystsResult = videoAnalyzer.analyze(videoFeautre); // 동영상 분석
        featureRepository.save(videoAnalystsResult); // 분석 결과 저장

        // 기타 로직

        return videoAnalystsResult;
    }
}
