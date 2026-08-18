package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fileName",nullable = false)
    private String fileName;

    @Column(name = "fileType")
    private String fileType;

    @Column(name = "fileSize")
    private Long fileSize;

    @Column(name="uploadTime")
    private LocalDateTime uploadTime;

    @Lob
    @Column(name = "date",columnDefinition = "LONGBLOB")
    private byte[] data;
}