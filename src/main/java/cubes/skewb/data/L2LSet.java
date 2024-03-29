package cubes.skewb.data;

import cubes.Case;
import cubes.Set;

import java.util.ArrayList;
import java.util.List;

public class L2LSet implements Set {
    private int id;
    private String name;
    private List<Case> cases;

    public L2LSet(int id, String name) {
        this.id = id;
        this.name = name;
        this.cases = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "L2LSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cases=" + cases +
                '}';
    }

    public void addCase(L2LCase l2LCase) {
        this.cases.add(l2LCase);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }
}
