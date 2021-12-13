package com.bechtle.eagl.webapp.controller;

import com.bechtle.eagl.webapp.model.metadata.MBirdAcademy;
import com.bechtle.eagl.webapp.model.metadata.MImport;
import com.bechtle.eagl.webapp.model.metadata.MList;
import com.bechtle.eagl.webapp.model.metadata.MType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetadataApi {

    @RequestMapping(value="/metadata", produces= MediaType.APPLICATION_XML_VALUE)
    public MImport loadMetadata() {
        MImport mImport = new MImport();
        mImport.getList().add(getAcademy());

        return mImport;
    }

    private MList getAcademy() {
        MBirdAcademy academy = new MBirdAcademy();
        academy.setId("EAGL");
        academy.setKurzname("Generierte Lernpfade");
        academy.setName("Generierte Lernpfade für kostenfreie Inhalte");

        MList mList = new MList();
        mList.setType(MType.BIRD_ACADEMY);
        mList.getBirdAcademy().add(academy);
        return mList;
    }

}
