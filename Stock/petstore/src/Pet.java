

public class Pet {
    private Integer id;
    private String name;
    private Integer age;
    private String kind;
    private String sex;
    private String isEpidemicPrevention;
    public Pet() {}
    // get、set方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIsEpidemicPrevention() {
        return isEpidemicPrevention;
    }

    public void setIsEpidemicPrevention(String isEpidemicPrevention) {
        this.isEpidemicPrevention = isEpidemicPrevention;
    }
}

