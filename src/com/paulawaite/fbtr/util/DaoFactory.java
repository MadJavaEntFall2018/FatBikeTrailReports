package com.paulawaite.fbtr.util;

import com.paulawaite.fbtr.persistence.AbstractDao;

/**
 * Created by paulawaite on 4/28/16.
 */
public class DaoFactory {

    // Empty constructor is private - static class
    private DaoFactory() {

    }

    public static AbstractDao createDao(Class type) {
        return new AbstractDao(type);

    }
}
