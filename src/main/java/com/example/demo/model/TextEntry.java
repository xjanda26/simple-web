package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TextEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private LocalDateTime createdAt;

    // Getters and setters
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
