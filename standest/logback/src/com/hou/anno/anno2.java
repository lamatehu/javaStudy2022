package com.hou.anno;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE}) //注解能在哪里使用
@Retention(RetentionPolicy.RUNTIME) // 可以存在到运行阶段
@Inherited //指定这个注解可以被继承
public @interface anno2 {
}
