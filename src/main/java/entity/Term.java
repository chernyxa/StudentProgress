package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Term {

    private int id;
    private String term;
    private String duration;
    private int status;
    private List<Discipline> disciplines = new ArrayList<>();

    public Term() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term1 = (Term) o;
        return id == term1.id && status == term1.status && Objects.equals(term, term1.term) && Objects.equals(duration, term1.duration) && Objects.equals(disciplines, term1.disciplines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, term, duration, status, disciplines);
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", term='" + term + '\'' +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                ", disciplines=" + disciplines +
                '}';
    }
}
