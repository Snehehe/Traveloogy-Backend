package cs450.repository;

import cs450.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayRepository extends JpaRepository<Stay, Long> {}
