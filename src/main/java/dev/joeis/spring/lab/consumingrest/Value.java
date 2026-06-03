package dev.joeis.spring.lab.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public record Value(Long id, String quote) {}
