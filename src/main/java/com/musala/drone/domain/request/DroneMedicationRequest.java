package com.musala.drone.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DroneMedicationRequest {

    @NotEmpty(message = "kindly provide a the drone serial number")
    @Size(max = 100, message = "Exceeded maximum number of character")
    String serialNumber;

    @Valid
    @NotEmpty(message = "kindly provide  medications list")
   List<MedicationRequest> medications;
}
