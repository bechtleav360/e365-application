package com.bechtle.eagl.webapp.controller;

import com.bechtle.eagl.webapp.model.metadata.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetadataApi {


    public MetadataApi() {

    }


    @RequestMapping(value = "/metadata", produces = MediaType.APPLICATION_XML_VALUE)
    public MImport loadMetadata() {

        return MImport
                .builder()
                .entity(getAcademy())
                .entity(getCourses())
                .build();
    }

    private MList getAcademy() {
        MBirdAcademy build = MBirdAcademy
                .builder()
                .id("EAGL")
                .kurzname("Generierte Lernpfade")
                .name("Generierte Lernpfade für kostenfreie Inhalte")
                .build();
        return MList.builder()
                .type("bird_academy")
                .academy(build)
                .build();


    }

    private MList getCourses() {
        return MList.builder()
                .type("bird_course")
                .course(MBirdCourse.builder()
                        .id("1")
                        .lectureType("Playlist")
                        .academyId("http://eagl.azurewebsites.net")
                        .name("Risikomanagement")
                        .build()
                )
                .course(MBirdCourse.builder()
                        .id("2")
                        .lectureType("Playlist")
                        .academyId("http://eagl.azurewebsites.net")
                        .name("Einführung in Scrum")
                        .build()
                )
                .course(MBirdCourse.builder()
                        .id("3")
                        .lectureType("Playlist")
                        .academyId("http://eagl.azurewebsites.net")
                        .name("Übersicht IT-Controlling")
                        .build()
                )
                .build();
    }

}
