package com.boylegu.springboot_vue.controller.pagination;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.boylegu.springboot_vue.dao.PersonsRepository;
import com.boylegu.springboot_vue.entities.Persons;


/*
    Resolve due to @Autowired lead to NullPointerException problem

    Description：
    1. It's limited to general class to invoke spring bean Object.
    2. And This makes the sub package easy to scan by spring boot.

                                                      ———— @Boyle.gu
*/
@Component
class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        if (SpringUtil.applicationContext == null) {

            SpringUtil.applicationContext = applicationContext;

        }
    }

    public static ApplicationContext getApplicationContext() {

        return applicationContext;

    }

    public static Object getBean(String name) {

        return getApplicationContext().getBean(name);

    }

    public static <T> T getBean(Class<T> clazz) {

        return getApplicationContext().getBean(clazz);

    }

    public static <T> T getBean(String name, Class<T> clazz) {

        return getApplicationContext().getBean(name, clazz);

    }
}


interface Types {

    public Page<Persons> query();

    public Integer getCount();

    public Integer getPageNumber();

    public Long getTotal();

    public Object getContent();
}

class BasePaginationInfo {

    public Pageable pageable;

    public PersonsRepository instance = SpringUtil.getBean(PersonsRepository.class);

    public String sex, email;

    public BasePaginationInfo(String sexName, String emailName, Pageable pageable) {

        this.pageable = pageable;

        this.sex = sexName;

        this.email = emailName;
    }
}

class AllType extends BasePaginationInfo implements Types {


    public AllType(String sexName, String emailName, Pageable pageable) { //String sexName, String emailName,

        super(sexName, emailName, pageable);

    }

    public Page<Persons> query() {

        return this.instance.findAll(

                this.pageable

        );
    }

    public Integer getCount() {
        return this.query().getSize();
    }

    public Integer getPageNumber() {

        return this.query().getNumber();

    }

    public Long getTotal() {
        return this.query().getTotalElements();
    }

    public Object getContent() {
        return this.query().getContent();
    }
}

class SexEmailType extends BasePaginationInfo implements Types {

    public SexEmailType(String sexName, String emailName, Pageable pageable) {

        super(sexName, emailName, pageable);

    }

    public Page<Persons> query() {

        return this.instance.findBySexAndEmailContains(

                this.sex,

                this.email,

                this.pageable
        );
    }

    public Integer getCount() {
        return this.query().getSize();
    }

    public Integer getPageNumber() {

        return this.query().getNumber();

    }

    public Long getTotal() {
        return this.query().getTotalElements();
    }

    public Object getContent() {
        return this.query().getContent();
    }


}

class SexType extends BasePaginationInfo implements Types {

    public SexType(String sexName, String emailName, Pageable pageable) { //String sexName, String emailName,

        super(sexName, emailName, pageable);
    }

    public Page<Persons> query() {

        return this.instance.findBySex(

                this.sex,

                this.pageable
        );
    }

    public Integer getCount() {
        return this.query().getSize();
    }

    public Integer getPageNumber() {

        return this.query().getNumber();

    }

    public Long getTotal() {
        return this.query().getTotalElements();
    }

    public Object getContent() {
        return this.query().getContent();
    }
}


public class PaginationFormatting {

    private PaginationMultiTypeValuesHelper multiValue = new PaginationMultiTypeValuesHelper();

    private Map<String, PaginationMultiTypeValuesHelper> results = new HashMap<>();

    public Map<String, PaginationMultiTypeValuesHelper> filterQuery(String sex, String email, Pageable pageable) {

        Types typeInstance;

        if (sex.length() == 0 && email.length() == 0) {

            typeInstance = new AllType(sex, email, pageable);

        } else if (sex.length() > 0 && email.length() > 0) {

            typeInstance = new SexEmailType(sex, email, pageable);

        } else {
            typeInstance = new SexType(sex, email, pageable);
        }

        this.multiValue.setCount(typeInstance.getCount());

        this.multiValue.setPage(typeInstance.getPageNumber() + 1);

        this.multiValue.setResults(typeInstance.getContent());

        this.multiValue.setTotal(typeInstance.getTotal());

        this.results.put("data", this.multiValue);

        return results;
    }

}