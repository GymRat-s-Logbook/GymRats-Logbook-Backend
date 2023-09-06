package com.gymrats.model;

import java.time.LocalDate;

public record BmrNotLoggedRequest(GenderEnum sex, LocalDate dateOfBirth, float weight, float height) {}
