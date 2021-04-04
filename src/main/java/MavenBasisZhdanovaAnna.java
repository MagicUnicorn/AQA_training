import java.util.ArrayList;
import java.util.HashSet;
import com.google.common.collect.Sets;
import java.util.Set;

public class MavenBasisZhdanovaAnna {

    ArrayList<String> listNameA = getListNameA();
    public ArrayList<String> getListNameA(){
        ArrayList<String> setNameA = new ArrayList<String>();
        setNameA.add("Alexandra");
        setNameA.add("Anna");
        setNameA.add("Artem");
        setNameA.add("Irina");
        setNameA.add("Nastya");
        setNameA.add("Natalia");
        setNameA.add("Olga");
        return setNameA;
    }

    ArrayList<String> listNameB = getListNameB();
    public ArrayList<String> getListNameB(){
        ArrayList<String> setNameB = new ArrayList<String>();
        setNameB.add("Alexandra");
        setNameB.add("Artem");
        setNameB.add("Olga");
        setNameB.add("Vladislav");
        setNameB.add("Viktoria");
        return setNameB;
    }
    Set<String> setNameA = new HashSet<>(listNameA);
    Set<String> setNameB = new HashSet<>(listNameB);

    Set<String> setNameFirst = Sets.newHashSet(listNameA);
    Set<String> setNameSecond = Sets.newHashSet(listNameB);

    public ArrayList<String> intersection(){
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i< listNameA.size(); ++i){
            for (int j = 0; j< listNameB.size(); ++j){
                String nameA = listNameA.get(i);
                String nameB = listNameB.get(j);
                if (nameA.equals(nameB)){
                    result.add(nameA);
                }
            }
        }
        return result;
    }

    public ArrayList<String> symmetricDifference(){
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i< listNameA.size(); ++i){
            String nameA = listNameA.get(i);
            Boolean isEqualA = Boolean.FALSE;
            for (int j = 0; j< listNameB.size(); ++j){
                String nameB = listNameB.get(j);
                if (nameA.equals(nameB)){
                    isEqualA = Boolean.TRUE;
                    break;
                }
            }
            if (!isEqualA) {
                result.add(nameA);
            }
        }
        for (int i = 0; i< listNameB.size(); ++i){
            String nameB = listNameB.get(i);
            Boolean isEqualB = Boolean.FALSE;
            for (int j = 0; j< listNameA.size(); ++j){
                String nameA = listNameA.get(j);
                if (nameA.equals(nameB)){
                    isEqualB = Boolean.TRUE;
                }
            }
            if (!isEqualB) {
                result.add(nameB);
            }
        }
        return result;
    }

    public ArrayList<String> union(){
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i< listNameA.size(); ++i){
            String nameA = listNameA.get(i);
            Boolean isEqual = Boolean.FALSE;
            if (listNameB.contains(nameA)) {
                isEqual = Boolean.TRUE;
            }
            if (!isEqual) {
                result.add(nameA);
            }
        }
        result.addAll(listNameB);
        return result;
    }

    public ArrayList<String> subtract(){
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i< listNameA.size(); ++i){
            String nameA = listNameA.get(i);
            Boolean isEqual = Boolean.FALSE;
            if (listNameB.contains(nameA)) {
                isEqual = Boolean.TRUE;
            }
            if (!isEqual) {
                result.add(nameA);
            }
        }
        return result;
    }

    public Set<String> intersectionSet(){
        Set<String> intersection = new HashSet<String>(setNameA);
        intersection.retainAll(setNameB);
        return intersection;
    }

    public Set<String> symmetricDifferenceSet(){
        Set<String> symmetricDiff = new HashSet<String>(setNameA);
        symmetricDiff.addAll(setNameB);
        // symmetricDiff now contains the union
        Set<String> tmp = new HashSet<String>(setNameA);
        tmp.retainAll(setNameB);
        // tmp now contains the intersection
        symmetricDiff.removeAll(tmp);
        // union minus intersection equals symmetric-difference
        return symmetricDiff;
    }

    public Set<String> unionSet(){
        Set<String> union = new HashSet<String>(setNameA);
        union.addAll(setNameB);
        return union;
    }

    public Set<String> subtractSet(){
        Set<String> subtract = new HashSet<String>(setNameA);
        subtract.removeAll(setNameB);
        return subtract;
    }


    public Set<String> intersectionGuava(){
        Set<String> intersection = Sets.intersection(setNameFirst, setNameSecond);
        return intersection;
    }

    public Set<String> symmetricDifferenceGuava(){
        Sets.difference(setNameFirst, setNameSecond);
        Set<String> symmetricDiff = Sets.symmetricDifference(setNameFirst, setNameSecond);
        return symmetricDiff;
    }

    public Set<String> unionGuava(){
        Set<String> union = Sets.union(setNameFirst, setNameSecond);
        return union;
    }

    public Set<String> subtractGuava(){
        Set<String> subtract = Sets.difference(setNameFirst, setNameSecond);
        return subtract;
    }


    public static void main(String[] args) {
        MavenBasisZhdanovaAnna mavenBasisZhdanovaAnna = new MavenBasisZhdanovaAnna();
        ArrayList <String> intersection = mavenBasisZhdanovaAnna.intersection();
        System.out.println("intersection: " + intersection);
        ArrayList <String> symmetricDifference = mavenBasisZhdanovaAnna.symmetricDifference();
        System.out.println("symmetric difference: " + symmetricDifference);
        ArrayList <String> union = mavenBasisZhdanovaAnna.union();
        System.out.println("union: " + union);
        ArrayList <String> subtract = mavenBasisZhdanovaAnna.subtract();
        System.out.println("subtract: " + subtract);
        System.out.println("====== Using Guava ======");
        Set<String> intersectionGuava = mavenBasisZhdanovaAnna.intersectionGuava();
        System.out.println("intersection" + intersectionGuava);
        Set<String> symmetricDifferenceGuava = mavenBasisZhdanovaAnna.symmetricDifferenceGuava();
        System.out.println("symmetric difference: " + symmetricDifferenceGuava);
        Set<String> unionGuava = mavenBasisZhdanovaAnna.unionGuava();
        System.out.println("union" + unionGuava);
        Set<String> subtractGuava = mavenBasisZhdanovaAnna.subtractGuava();
        System.out.println("subtract: " + subtractGuava);
        System.out.println("====== On sets ======");
        Set<String> intersectionSet = mavenBasisZhdanovaAnna.intersectionSet();
        System.out.println("intersection" + intersectionSet);
        Set<String> symmetricDifferenceSet = mavenBasisZhdanovaAnna.symmetricDifferenceSet();
        System.out.println("symmetric difference: " + symmetricDifferenceSet);
        Set<String> unionSet = mavenBasisZhdanovaAnna.unionSet();
        System.out.println("union" + unionSet);
        Set<String> subtractSet = mavenBasisZhdanovaAnna.subtractSet();
        System.out.println("subtract: " + subtractSet);
    }

}
