package secondleginterview.easylevel;

public class ContainerwithmostWater {
    public static void main(String[] args) {
        int container[] = {1,8,6,2,5,4,8,3,7};

        int left=0,right=container.length-1;
        int maxArea=0;

        while(left<right){
            maxArea = Math.max(maxArea,Math.min(container[left],container[right])*(right-left));

            if(container[left]<container[right]){
                left++;
            }
            else
                right--;
        }
        System.out.println(maxArea);
    }
}
