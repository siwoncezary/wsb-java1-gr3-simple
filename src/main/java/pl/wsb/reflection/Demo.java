package pl.wsb.reflection;

import pl.wsb.model.Panel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        final Constructor<?>[] constructors = Panel.class.getDeclaredConstructors();
        for(Constructor c: constructors){
            System.out.println(c.getName() + " " + c.getParameterCount() + " " + Arrays.asList(c.getParameterTypes()));
        }
        final Panel instance = (Panel) constructors[0].newInstance(3, 4, 100, "XXX");
        System.out.println(instance);
        Field[] fields = Panel.class.getDeclaredFields();
        for(Field f: fields){
            System.out.println(f.getName());
        }
        Field sideAField = Panel.class.getDeclaredField("sideA");
        //udostępnienie składowej prywatnej
        sideAField.setAccessible(true);
        System.out.println("Pole sideA " + sideAField.getDouble(instance));
        Method[] methods = Panel.class.getDeclaredMethods();
        for(Method m: methods){
            System.out.println(m.getName());
        }
    }
}
