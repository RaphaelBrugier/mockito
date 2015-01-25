package org.mockitousage.spies;

import org.junit.Test;
import org.mockitoutil.TestBase;

import static org.mockito.Mockito.spy;

public class SpyingOnDefaultMethods extends TestBase {

    public static interface InterfaceBase {
        String getFoo();
    }

    public static interface InterfaceWithDefault extends  InterfaceBase {
        default String getFoo() {
            return "foo";
        }
    }

    public static abstract class ClassBase implements InterfaceBase {}

    public static abstract class ClassConcrete extends ClassBase implements InterfaceWithDefault {
        abstract String getBar();
    }

    @Test
    public void shouldAcceptSpyOnDefaultMethods() {
//        ClassConcrete concreteClass = new ClassConcrete();
//        assertEquals(concreteClass.getFoo(), "foo");

        ClassConcrete concreteClassSpied = spy(ClassConcrete.class);
//        assertEquals(concreteClassSpied.getBar(), null);
        assertEquals(concreteClassSpied.getFoo(), "foo");
    }
}