package entity;

public class IngTurk {
    private Long id;
    private TurkSozluk tr;
    private IngSozluk ing;

    public IngTurk() {
    }

    public IngTurk(Long id, TurkSozluk tr, IngSozluk ing) {
        this.id = id;
        this.tr = tr;
        this.ing = ing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TurkSozluk getTr() {
        return tr;
    }

    public void setTr(TurkSozluk tr) {
        this.tr = tr;
    }

    public IngSozluk getIng() {
        return ing;
    }

    public void setIng(IngSozluk ing) {
        this.ing = ing;
    }
}
