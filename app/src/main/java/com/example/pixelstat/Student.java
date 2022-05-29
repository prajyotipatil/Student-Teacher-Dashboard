package com.example.pixelstat;

public class Student {

    private String sname;
    private String fname;
    private String iname;
    private String batch;
    private String m1;
    private String m2;
    private String m3;

    public Student(){

    }

    public Student(String sname,String fname,String iname,String batch,String m1,String m2,String m3){
        this.sname=sname;
        this.fname=fname;
        this.iname=iname;
        this.batch=batch;
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
    }

    public String getSname(){
        return sname;
    }
    public void setSname(String sname){
        this.sname=sname;
    }
    public String getFname(){
        return fname;
    }
    public void setFname(String sname){
        this.fname=fname;
    }
    public String getIname(){
        return iname;
    }
    public void setIname(String iname){
        this.iname=iname;
    }
    public String getBatch(){
        return batch;
    }
    public void setBatch(String batch){
        this.batch=batch;
    }
    public String getM1(){
        return m1;
    }
    public void setM1(String m1){
        this.m1=m1;
    }
    public String getM2(){
        return m2;
    }
    public void setM2(String m2){
        this.m2=m2;
    }
    public String getM3(){
        return m3;
    }
    public void setM3(String m3){
        this.m3=m3;
    }


}
