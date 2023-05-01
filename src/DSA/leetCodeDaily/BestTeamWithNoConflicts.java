package DSA.leetCodeDaily;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
    int score;
    int age;

    Person(int score, int age) {
        this.score = score;
        this.age = age;
    }
}

class PersonComparator implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        if (o1.age < o2.age) return -1;
        else if (o1.age > o2.age) return 1;
        else if (o1.score < o2.score) return -1;
        return 1;
    }
}

public class BestTeamWithNoConflicts {
    public static void main(String[] args) {

        int scores[] = {4, 5, 6, 5}, ages[] = {2, 1, 2, 1};

        System.out.println(new BestTeamWithNoConflicts().bestTeamScore(scores, ages));

    }

    public int bestTeamScore(int[] scores, int[] ages) {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            personList.add(new Person(scores[i], ages[i]));
        }
        Collections.sort(personList, new PersonComparator());
        int max = Integer.MIN_VALUE;
        int ans[] = new int[scores.length];
        ans[0] = personList.get(0).score;
        Person pre = personList.get(0);
        for (int i = 1; i < personList.size(); i++) {
            Person curr = personList.get(i);
            if ( curr.score >= pre.score) {
                ans[i] = ans[i - 1] + curr.score;
                max=ans[i];
            }
            else{

            }

        }

        return -1;
    }
}
