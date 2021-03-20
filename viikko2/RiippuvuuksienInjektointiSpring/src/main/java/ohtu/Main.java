package ohtu;

import ohtu.laskin.KonsoliIO;
import ohtu.laskin.Laskin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Laskin laskin = ctx.getBean(Laskin.class);
        
        laskin.suorita();
    }
}














//        //Koe k = ctx.getBean(Koe.class);
//        Koe k = (Koe)ctx.getBean("koe");
//        k.foo();
//        
//        IO io = ctx.getBean(IO.class);
//        io.print("paska");