package com.hou.test1;

public class test1 {
    public static void main(String[] args) {
       outer.inner aa = new outer().new inner();
       aa.print();
    }
}

class outer{
    public class inner{
        public void print(){
            System.out.println("aaaa");
        }
    }
}

class outer2{
    private class inner2{
        public void print(){
            System.out.println("aaaa");
        }
    }
}
