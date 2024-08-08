public class Champion {
    int id;
    String name;
    String clazz;
    int style;
    int difficulty;

    public Champion(int id, String name, String clazz, int style, int difficulty) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
        this.style = style;
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clazz='" + clazz + '\'' +
                ", style=" + style +
                ", difficulty=" + difficulty +
                '}';
    }
}
