package com.opentelemetry.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;

@Configuration
public class OpenTelemetryConfig {

	@Bean
	public OtlpHttpSpanExporter otlpHttpSpanExporter(@Value("${tracing.url.endpoint}") String endpoint) {
		return OtlpHttpSpanExporter.builder().setEndpoint(endpoint).build();
	}

}
