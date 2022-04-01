package com.consulting.app.consultingappbackend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.*;
import java.util.List;

@Document(collection = "candidates")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Candidate {

    @Id
    private String id;

    @NotBlank(message = "Enter name")
    private String name;

    @NotBlank(message = "Enter email id")
    @Field("email_id")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "must be a valid email id")
    private String emailId;

    @NotBlank(message = "Enter Phone no")
    @Field("phone_no")
    @Size(min = 10 , max = 10 ,message = "must contain 10 digits")
    private String phoneNo;

    @NotEmpty
    private List<String > skills;

    @NotEmpty
    private List<String > qualification;

    @Min(1)
    private int experience;

    private String status;

    @Field("created_on")
    private String createdOn;

    @Field("last_updated_on")
    private String lastUpdatedOn;
}
