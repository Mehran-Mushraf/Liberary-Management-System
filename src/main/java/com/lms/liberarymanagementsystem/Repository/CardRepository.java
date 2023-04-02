package com.lms.liberarymanagementsystem.Repository;

import com.lms.liberarymanagementsystem.Entity.LiberaryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<LiberaryCard, Integer> {
}
