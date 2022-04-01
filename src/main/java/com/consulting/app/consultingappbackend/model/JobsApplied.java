package com.consulting.app.consultingappbackend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;

@Document(collection = "jobs_applied")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class JobsApplied {

    @Id
    private String id;

    @Field("job_id")
    @NotBlank(message = "Enter job id")
    private String jobId;

    @Field("email_id")
    @NotBlank(message = "Enter email id")
    private String emailId;

    private String status;

}
