package zerobase.weatherdiary.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zerobase.weatherdiary.domain.Diary;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Integer> {
    //동작방식을 지정해주지 않았지만 Jpa가 알아서 query를 생성해서 데이터를 가져와준다.
    List<Diary> findAllByDate(LocalDate date);

    List<Diary> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

    Diary getFirstByDate(LocalDate date);

    @Transactional //달아주지 않으면 오류
    void deleteAllByDate(LocalDate date);
}
