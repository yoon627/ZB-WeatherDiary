package zerobase.weatherdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zerobase.weatherdiary.domain.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Integer> {
}
