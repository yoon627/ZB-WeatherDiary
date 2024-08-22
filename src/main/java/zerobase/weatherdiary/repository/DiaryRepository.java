package zerobase.weatherdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weatherdiary.domain.Diary;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Integer> {
    //동작방식을 지정해주지 않았지만 Jpa 가 알아서 query 를 생성해서 데이터를 가져와준다.
    List<Diary> findAllByDate(LocalDate date);

    List<Diary> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

    Diary getFirstByDate(LocalDate date);

    //조회를 제외한 C,U,D가 포함된 DB에 직접적인 변화를 주는
    // 커스텀 트랜잭션을 날려줄때는 transactional 을 명시해주는 것이 좋다
    @Transactional
    void deleteAllByDate(LocalDate date);
}
