package com.example.demo.repository;

import com.example.demo.model.TextEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextEntryRepository extends JpaRepository<TextEntry, Long> {
}