package com.blog;

public class PostDto {

    private  long id   ;
    private  String content  ;
    private  String title  ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    //    public static void main(String[] args) {
////        Function<Integer , String > myFunction = i->"Result:"+i ;
////        String apply = myFunction.apply(4);
////        System.out.println(apply);
////
////        Function<Integer , Double > myFuction2 = i->i*1.3 ;
////        Double apply1 = myFuction2.apply(100);
////        System.out.println(apply1);
////        Supplier<A> mySupplier = () ->new A();
////         A s = mySupplier.get();
////         System.out.println(s);
////        Consumer<String> myConsumer =s -> System.out.println("Consumed:"+s);
////        myConsumer.accept("hellow ");
//
//
//    }

}
