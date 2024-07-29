package com.ust.Ust_Projects.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class Project {

    @Id
    private int projectId;
    private String projectName;
    private String projectDescription;
    private String projectLink;
    private String psnumber;
    @Enumerated(value= EnumType.STRING)
    private ProjectStatus projectStatus;

}
