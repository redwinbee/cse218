package p1_intro;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        for (int i = 0; i < args.length; i++) {
            System.out.printf("args[%d]: %s%n", i, args[i]);
        }

        try {
            Class<?> clazz = Class.forName(args[0]);
            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("[inf]: methods available in " + clazz + ":");
            for (Method method : methods) {
                System.out.println(method.toString());
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("[err]: can't find class " + args[0]);
        }
    }
}
