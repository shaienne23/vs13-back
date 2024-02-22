package com.kafka.producer.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReceitaDTO {
    private String nome;
    private List<String> ingredientes;
    private Long id;
    private Double valorReceita;
}
