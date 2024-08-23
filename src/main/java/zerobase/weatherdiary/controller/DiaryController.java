package zerobase.weatherdiary.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zerobase.weatherdiary.domain.Diary;
import zerobase.weatherdiary.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @Operation(summary = "일기 텍스트와 날씨를 이용해 DB에 일기 저장", description = "날씨 일기를 생성합니다.")
    @PostMapping("/create/diary")
    void createDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "생성 날짜", example = "2024-08-23") LocalDate date,
            @RequestBody @Parameter(description = "일기 내용", example = "안녕하세요!") String text) {
        diaryService.createDiary(date, text);
    }

    @Operation(summary = "선택한 날짜의 모든 일기 데이터 조회", description = "날씨 일기를 조회합니다.")
    @GetMapping("/read/diary")
    List<Diary> readDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "조회 날짜", example = "2024-08-23") LocalDate date) {
        return diaryService.readDiary(date);
    }

    @Operation(summary = "선택한 기간동안 모든 일기 데이터 조회", description = "기간동안 날씨 일기를 조회합니다.")
    @GetMapping("/read/diaries")
    List<Diary> readDiaries(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "시작 날짜", example = "2024-08-23") LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "끝 날짜", example = "2024-08-23") LocalDate endDate) {
        return diaryService.readDiaries(startDate, endDate);
    }

    @Operation(summary = "선택한 날의 첫번째 일기 수정", description = "날씨 일기를 수정합니다.")
    @PutMapping("/update/diary")
    void updateDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "수정 날짜", example = "2024-08-23") LocalDate date,
            @RequestBody String text) {
        diaryService.updateDiary(date, text);
    }

    @Operation(summary = "선택한 날의 일기들 삭제", description = "날씨 일기를 삭제합니다.")
    @DeleteMapping("/delete/diary")
    void deleteDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Parameter(description = "삭제 날짜", example = "2024-08-23") LocalDate date) {
        diaryService.deleteDiary(date);
    }
}
