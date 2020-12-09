package junitItescia.services.Exercice2;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class VectorObj {
    public static Vector<Object> unionSet(Vector<Object> a, Vector<Object> b) {

        Vector<Object> vector = new Vector<Object>();
               
               Set<Object> temp = new HashSet<Object>();
               temp.addAll(a);
               temp.addAll(b);
               
               vector.addAll(temp);
               return vector;
           
       

    }

}
