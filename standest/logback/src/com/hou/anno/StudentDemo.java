package com.hou.anno;

import java.lang.annotation.Annotation;

public class StudentDemo implements anno2 {
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
