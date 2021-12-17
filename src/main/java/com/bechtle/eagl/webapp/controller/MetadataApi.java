package com.bechtle.eagl.webapp.controller;

import com.bechtle.eagl.webapp.model.metadata.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetadataApi {

    private ObjectFactory objectFactory;

    public MetadataApi(@Autowired ObjectFactory objectFactory) {

        this.objectFactory = objectFactory;
    }


    @RequestMapping(value="/metadata", produces= MediaType.APPLICATION_XML_VALUE)
    public Import loadMetadata() {

        Import mImport = objectFactory.createImport();
        mImport.getList().add(getAcademy());
        mImport.getList().add(getCourse());

        return mImport;
    }

    private MList getAcademy() {
        MBirdAcademy academy = objectFactory.createMBirdAcademy();
        academy.setId("EAGL");
        academy.setKurzname("Generierte Lernpfade");
        academy.setName("Generierte Lernpfade für kostenfreie Inhalte");

        MList mList = new MList();
        mList.setType(MType.BIRD_ACADEMY);
        mList.getBirdAcademy().add(academy);
        return mList;
    }

    private MList getCourse() {
        MBirdCourse course = new MBirdCourse();
        course.setId("IT-Controlling");
        course.setLectureType("Playlist");
        course.setAcademyId("WWW");
        course.setLectureType("Kurs");

        MList mList = new MList();
        mList.setType(MType.BIRD_COURSE);
        mList.getBirdCourse().add(course);
        return mList;
    }

}
