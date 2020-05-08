package org.ds.algos.practice.ds.algos;

public class HashFunction {

    String name;
    int age;
    String rollNumber;
    String Section;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Section == null) ? 0 : Section.hashCode());
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((rollNumber == null) ? 0 : rollNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HashFunction other = (HashFunction) obj;
        if (Section == null) {
            if (other.Section != null)
                return false;
        } else if (!Section.equals(other.Section))
            return false;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (rollNumber == null) {
            if (other.rollNumber != null)
                return false;
        } else if (!rollNumber.equals(other.rollNumber))
            return false;
        return true;
    }


}
