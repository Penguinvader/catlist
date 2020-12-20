package com.penguinvader.catlist;

import java.util.List;

import com.penguinvader.catlist.CatUITO;

public interface CatService {
    CatUITO doSaveEmp(CatUITO employeeUiTO);

    List<CatUITO> doFetchAllCat();

    CatUITO doGetCat(CatUITO catUiTO);

    void doDeleteCat(CatUITO catUiTO);
}