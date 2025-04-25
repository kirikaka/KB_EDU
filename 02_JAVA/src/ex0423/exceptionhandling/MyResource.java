package ex0423.exceptionhandling;

public class MyResource implements AutoCloseable {
    private String name;

    public MyResource(String name)  {
        this.name = name;
        System.out.println("[MyResources("+name+") 열기]");
    }

    public String read1(){
        System.out.println("[MyResources("+name+") 읽기]");
        return "100";
    }

    public String read2(){
        System.out.println("[MyResources("+name+") 읽기]");
        return "abc";
    }

    @Override
    public void close() throws Exception {
        System.out.println("[MyResources("+name+") 닫기]");

    }
}
