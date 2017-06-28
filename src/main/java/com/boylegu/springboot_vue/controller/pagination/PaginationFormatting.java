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

class AllType implements Types {


    private Pageable pageable;

    public String sex, email;


    public AllType(Pageable pageable) { //String sexName, String emailName,
        // super(sexName, emailName, pageable);
        this.pageable = pageable;
    }

    public Page<Persons> query() {

        System.out.println(SpringUtil.getBean(PersonsRepository.class).findAll());
        return SpringUtil.getBean(PersonsRepository.class).findAll(
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

// class SexType extends BasePaginationInfo implements Types {
//     public Page<Persons> query(String sexName, String emailName) {
//         return personsRepository.findBySex(
//                 sexName,
//                 pageable
//         );
//     }
// }
//
// class SexMailType extends BasePaginationInfo implements Types {
//     public Page<Persons> query(String sexName, String emailName) {
//         return personsRepository.findBySexAndEmailContains(
//                 sexName,
//                 emailName,
//                 pageable
//         );
//     }
// }


public class PaginationFormatting {

    private PaginationMultiTypeValuesHelper multiValue = new PaginationMultiTypeValuesHelper();

    private Map<String, PaginationMultiTypeValuesHelper> results = new HashMap<>();

    public Map<String, PaginationMultiTypeValuesHelper> filterQuery(String sex, String email, Pageable pageable) {

        if (sex.length() == 0 && email.length() == 0) {
            // Types typeInstance = new AllType(sex, email, pageable);
            Types typeInstance = new AllType(pageable);
            this.multiValue.setCount(typeInstance.getCount());

            this.multiValue.setPage(typeInstance.getPageNumber() + 1);

            this.multiValue.setResults(typeInstance.getContent());

            this.multiValue.setTotal(typeInstance.getTotal());

            this.results.put("data", this.multiValue);

        }

        return results;
    }

}