package com.test;

public class StaticExtends {  
	  
    public static void main(String[] args) {  
        Father son = new Son(); //声明为Father类,son1静态方法和Father类绑定  
       
        son.method();  
        son.staticMethod();   
        Son son2 = new Son();  
        son2.method();  
        son2.staticMethod();  
      
        
    }  
}  
class Father{  
    void method(){  
        System.out.println("父类方法");  
    }  
      
    
    void test(){
    	System.out.println("father test");
    	
    }
    static void staticMethod(){  
        System.out.println("父类静态方法");  
    }  
}    
class Son extends Father{  
      
    void method(){  
        System.out.println("子类方法");  
    }  
      void test2(){
    	  System.out.println("son");
      }
    static void staticMethod(){  
        System.out.println("子类静态方法");  
    }  
}  
