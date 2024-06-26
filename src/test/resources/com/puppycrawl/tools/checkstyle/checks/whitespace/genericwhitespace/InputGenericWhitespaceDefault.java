/*
GenericWhitespace


*/

package com.puppycrawl.tools.checkstyle.checks.whitespace.genericwhitespace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.Collections;
class InputGenericWhitespaceDefault implements Comparable<Object>, Serializable
{
    void meth()
    {
        List<Integer> x = new ArrayList<Integer>();
        List<List<Integer>> y = new ArrayList<List<Integer>>();
        List < Integer > a = new ArrayList < Integer > (); // 7 violations
        List < List < Integer > > b = new ArrayList < List < Integer > > (); // 15 violations
    }
    //always 0
    public int compareTo(Object aObject)
    {
        return 0;
    }

    public static <T> Callable<T> callable(Runnable task, T result)
    {
        return null;
    }

    public static<T>Callable<T> callable2(Runnable task, T result) // 2 violations
    {
        Map<Class<?>, Integer> x = new HashMap<Class<?>, Integer>();
        for (final Map.Entry<Class<?>, Integer> entry : x.entrySet()) {
            entry.getValue();
        }
        Class<?>[] parameterClasses = new Class<?>[0];
        return null;
    }
    public int getConstructor(Class<?>... parameterTypes)
    {
        Collections.<Object>emptySet();
        Collections. <Object> emptySet(); // 2 violations
        return 666;
    }

    <T> InputGenericWhitespaceDefault(List<T> things, int i)
    {
    }

    public <T> InputGenericWhitespaceDefault(List<T> things)
    {
    }

    public interface IntE { /*inner enum*/
    }

    public static class IntEnumValueType<E extends Enum<E> & IntE> {
    }

    class IntEVT2<E extends Enum<E>& IntE> { // violation ''&' is not preceded with whitespace.'
    }

    class IntEVT3<E extends Enum<E>  & IntE> { // violation ''>' is followed by whitespace.'
    }

    public static class IntEnumValueType4<T extends Comparable<List<T>> & IntE> {
    }

    public void beforeAndAfter() {
        List
<
Integer> x = new ArrayList<Integer
>();
        List
        <Integer> y = new ArrayList<Integer
        >();
        Map<Class<?>, Integer> a = new HashMap<Class<?>, Integer>();
        Map<Class<?>, Integer> b = (Map<Class<?>, Integer>) a;
    }
    Object ok = new <String>Object();
    Object notOkStart = new<String>Object(); // violation ''<' is not preceded with whitespace.'
    Object notOkEnd = new <String> Object(); // violation ''>' is followed by whitespace.'
    Object notOkStartAndEnd = new<String> Object(); // 2 violations
    Object okWithPackage = new <String>java.lang.Object();
    Object ok2 = new <String>Outer.Inner();
    Object notOkSt2 = new<String>Outer.Inner(); // violation ''<' is not preceded with whitespace.'
    Object notOkEnd2 = new <String> Outer.Inner(); // violation '>' is followed by whitespace.'
    Object notOkStartAndEnd2 = new<String> Outer.Inner(); // 2 violations
}
interface SupplierFunction<T> extends Map<List<T>, T> {}

class Outer {
    static class Inner {}
}
