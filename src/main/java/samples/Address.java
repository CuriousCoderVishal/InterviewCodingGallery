package samples;

import lombok.Builder;


public class Address {
    private final String pincode;
    private final String  streetName;
    private final String   FlatNo;
    private final String  OwnerName;

    public Address(Builder builder) {
        this.pincode = builder.pincode;
        this.streetName = builder.streetName;
        this.FlatNo = builder.FlatNo;
        this.OwnerName = builder.OwnerName;
    }

    static class Builder{
       private String pincode;
       private String streetName;
       private String FlatNo;
       private String OwnerName;

       public Builder(){

       }

       public Builder withPincode(String pincode){
           this.pincode = pincode;
            return this;
       }
       public Builder withStreetName(String streetName){
            this.streetName = streetName;
            return this;
       }
       public Builder withFlatNo(String FlatNo){
            this.FlatNo = FlatNo;
            return this;
       }
      public Builder withOwnerName(String OwnerName){
           this.OwnerName = OwnerName;
           return this;
      }

      public Address build(){
           return new Address(this);
      }
   }
}


