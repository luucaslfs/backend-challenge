package com.luucaslfs.backendchallenge.service;

import com.luucaslfs.backendchallenge.model.Status;
import com.luucaslfs.backendchallenge.repository.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class StatusCommandLineRunner implements CommandLineRunner {

    private final StatusRepository statusRepository;

    public StatusCommandLineRunner(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createDefaultStatuses();
    }

    private void createDefaultStatuses() {
        List<String> statusNames = Arrays.asList("NEVER_ACTIVATED", "PURCHASED", "CANCELLED", "RESTARTED");
        statusNames.forEach(statusName -> {
            Optional<Status> optionalStatus = statusRepository.findByStatusName(statusName);
            if (optionalStatus.isEmpty()) {
                Status status = new Status();
                status.setStatusName(statusName);
                statusRepository.save(status);
            }
        });
    }
}
