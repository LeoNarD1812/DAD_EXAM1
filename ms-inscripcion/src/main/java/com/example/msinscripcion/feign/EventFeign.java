package com.example.msinscripcion.feign;


import com.example.msinscripcion.dto.EventDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-evento-service", path = "/evento")
public interface EventFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "eventListByIdCB", fallbackMethod = "eventListById")
    public ResponseEntity<EventDto> getById(@PathVariable Integer id);
        default ResponseEntity<EventDto> eventListById(Integer id, Exception e) {
        return ResponseEntity.ok(new EventDto());
    }
}
