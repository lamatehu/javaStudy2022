package com.hou.enumDemo;

public enum sesson {
    Spring("春"){
        @Override
        public void show() {
            System.out.println(Spring.name+"你好春天");
        }
    },Winter("冬"){
        @Override
        public void show() {
            System.out.println(Winter.name+"你好冬天");
        }
    },Autumn("秋"){
        @Override
        public void show() {
            System.out.println(Autumn.name+"你好秋");
        }
    },Summer("夏"){
        @Override
        public void show() {
            System.out.println(Summer.name+"你好夏天");
        }
    };
    private sesson(){

    }
    private sesson(String name){
        name = this.name();
    }
    private String name;

    public abstract void show();
}
