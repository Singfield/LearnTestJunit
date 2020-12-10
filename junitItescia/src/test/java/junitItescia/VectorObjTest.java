package junitItescia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Vector;

import org.junit.jupiter.api.Test;

import junitItescia.services.Exercice2.VectorObj;

public class VectorObjTest {
    @Test
    public void testDataVector() {
        Vector<Object> vectorA = new Vector<Object>() {
            private static final long serialVersionUID = 1L;

            {
                add(1);
            }
        };
        Vector<Object> vectorB = new Vector<Object>() {
            private static final long serialVersionUID = 1L;

            {
                add(1);
            }
        };

        Vector<Object> vectorExpected = new Vector<Object>() {
            private static final long serialVersion = 1L;

            {
                add(1);
            }
        };

        Vector<Object> unionVector = VectorObj.unionSet(vectorA, vectorB);
        assertEquals(vectorExpected, unionVector);
    }

	@Test
    public void testKeepOrderDataVectorType(){
        Vector<Object> vectorA = new Vector<Object>() {
            private static final long serialVersion = 1L;

            {
                add("first");
            }
        };
        Vector<Object> vectorB = new Vector<Object>() {
            private static final long serialVersion = 1L;

            {
                add("second");
            }
        };
        Vector<Object> vectorExpected = new Vector<Object>() {
            private static final long serialVersion = 1L;

            {
            	add("first");
                add("second");
            }
        };
        

        Vector<Object> vectorObj = VectorObj.unionSet(vectorA, vectorB);
        assertEquals(vectorExpected, vectorObj);
    }
	

	@Test
    public void testKeepDifferentTypeDataAndKeepOrderVector(){
        Vector<Object> vectorA = new Vector<Object>() {
            private static final long serialVersion = 1L;

            {
                add("test");
            }
        };
        Vector<Object> vectorB = new Vector<Object>() {
			private static final long serialVersion = 1L;

			{
                add(10);
            }
        };
        Vector<Object> vectorExpected = new Vector<Object>() {
            private static final long serialVersion = 1L;

            {
            	add("test");
                add(10);
            }
        };
        

        Vector<Object> vectorObj = VectorObj.unionSet(vectorA, vectorB);
        assertEquals(vectorExpected, vectorObj);
    }
}
