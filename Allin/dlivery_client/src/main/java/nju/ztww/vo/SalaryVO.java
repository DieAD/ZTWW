package nju.ztww.vo;

public class SalaryVO {
    public final String id;
    public final String name;
    public final String pattern;
    public final double salary;
    
   public SalaryVO(String id, String name, String pattern, double salary){
	   this.id = id;
	   this.name = name;
	   this.pattern = pattern; 
	   this.salary = salary;
   }
}
