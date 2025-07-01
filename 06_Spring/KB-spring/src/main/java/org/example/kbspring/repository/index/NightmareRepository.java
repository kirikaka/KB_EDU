package org.example.kbspring.repository.index;


import org.example.kbspring.domain.index.Nightmare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NightmareRepository extends JpaRepository<Nightmare, Long> {}