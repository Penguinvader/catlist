package com.penguinvader.catlist;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

@Controller("catController")
@SessionScope
public class CatController {
    @Autowired
    private CatService catService;


    private String actionLabel;
    private CatUITO catUiTO;
    private List<CatUITO> catUiToList;

    /**
     * add or update new Record in DB
     *
     * @return
     */
    public void doSaveInfoCat() {
        System.out.println(this.getCatUiTO());
        catService.doSaveEmp(this.getCatUiTO());
        getAllCat();
        this.setCatUiTO(new CatUITO());
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Cat Details", "Cat Details added/Updated Successfully."));

    }

    /**
     * Default load all the Cat info
     */
    @PostConstruct
    public void getAllCat() {
        if (!this.getCatUiToList().isEmpty()) {
            this.getCatUiToList().clear();
        }
        System.out.println(" >>>>>>>>>>>>> " + catService);
        this.getCatUiToList().addAll(catService.doFetchAllCat());
        this.setActionLabel("Add");
    }

    /**
     * Remove selected Cat info
     *
     * @return
     */

    public void deleteCat(CatUITO catUiTO) {
        catService.doDeleteCat(catUiTO);
        getAllCat();
    }

    public void editCat(CatUITO catUiTO) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(catUiTO, this.getCatUiTO());
        System.out.println(this.getCatUiTO());
    }

    public CatUITO getCatUiTO() {
        if (catUiTO == null) {
            catUiTO = new CatUITO();
        }
        return catUiTO;
    }

    public void setCatUiTO(CatUITO empUiTO) {
        this.catUiTO = empUiTO;
    }

    public List<CatUITO> getCatUiToList() {
        if (null == catUiToList) {
            catUiToList = new ArrayList<>();
        }
        return catUiToList;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

}
