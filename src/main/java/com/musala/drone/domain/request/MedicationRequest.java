package com.musala.drone.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class MedicationRequest {

    @NotEmpty(message = "kindly provide a the name of the medication")
    String serialNumber;

    @NotEmpty(message = "kindly provide a the name of the medication")
    @Pattern(regexp = "[A-Za-z0-9_-]+", message = "invalid medication name")
    String name;

    @NotNull
    Double weight;

    @NotEmpty(message = "kindly provide a the name of the medication")
    @Pattern(regexp = "[A-Z0-9_]+", message = "invalid medication code")
    String code;

    MultipartFile image;
}
