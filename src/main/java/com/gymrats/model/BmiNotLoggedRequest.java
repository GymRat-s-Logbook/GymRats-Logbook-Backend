package com.gymrats.Dto.BmiNotLoggedRequest;

import com.gymrats.Dto.BmiNotLoggedResponse.BmiNotLoggedResponse;
import com.gymrats.model.GenderEnum;

public record BmiNotLoggedRequest(GenderEnum sex, float weight, float height) {


}
