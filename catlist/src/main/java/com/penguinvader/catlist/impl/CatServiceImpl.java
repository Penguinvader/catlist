package com.penguinvader.catlist.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.penguinvader.catlist.Cat;
import com.penguinvader.catlist.CatRepository;
import com.penguinvader.catlist.CatService;
import com.penguinvader.catlist.CatUITO;

@Service
@Transactional
public class CatServiceImpl implements CatService {
    @Autowired
    CatRepository catRepo;

    @Override
    @Transactional(readOnly = false)
    public CatUITO doSaveEmp(CatUITO catUiTO) {
        Cat dto = UiToToDto(catUiTO);
        dto = catRepo.save(dto);
        BeanUtils.copyProperties(dto, catUiTO);

        dtoToUito(catUiTO, dto);
        return catUiTO;
    }

    private void dtoToUito(CatUITO catUiTO, Cat dto) {
    }

    private Cat UiToToDto(CatUITO catUiTO) {
        Cat dto = new Cat();
        BeanUtils.copyProperties(catUiTO, dto);
        List<Cat> lst = new ArrayList<>();
        lst.add(dto);
        return dto;
    }

    @Override
    public List<CatUITO> doFetchAllCat() {
        List<Cat> dtoLst = catRepo.findAll();
        List<CatUITO> uiTOLst = new ArrayList<>();
        dtoLst.forEach(dto -> {
            CatUITO tmpUiTO = new CatUITO();
            BeanUtils.copyProperties(dto, tmpUiTO);

            dtoToUito(tmpUiTO, dto);
            uiTOLst.add(tmpUiTO);
        });
        return uiTOLst;
    }

    @Override
    public CatUITO doGetCat(CatUITO catUiTO) {
        if (null != catUiTO.getId()) {
            Cat dto = new Cat();

            BeanUtils.copyProperties(catUiTO, dto);
            dto = catRepo.getOne(dto.getId());

            BeanUtils.copyProperties(dto, catUiTO);
        }
        return catUiTO;
    }

    @Override
    @Transactional
    public void doDeleteCat(CatUITO catUiTO) {

        catRepo.deleteById(catUiTO.getId());
    }

}
