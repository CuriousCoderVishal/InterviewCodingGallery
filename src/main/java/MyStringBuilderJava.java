import javax.persistence.criteria.CriteriaBuilder;

public class MyStringBuilderJava {

    String value;

    public MyStringBuilderJava(String value) {
        this.value = value;
    }

    public MyStringBuilderJava conCatenate(String newString){
       return new MyStringBuilderJava(this.value+newString);
    }


}
