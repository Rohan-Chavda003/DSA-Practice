package arrayandhashing;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        mergeSort(nums  , 0 ,nums.length-1 );
        return nums;
    }
    void mergeSort(int[] nums , int l , int r){
        if(l < r ){
            int m = l + (r-l)/2;
            mergeSort(nums , l , m);
            mergeSort(nums , m+1 , r);

            merge(nums , l , m , r);
        }
    }
    void merge(int[] nums , int l , int m , int r){
        int size1 = m-l +1;
        int size2 = r-m;
        int[] temp1 = new int[size1];
        int[] temp2 = new int[size2];
        for(int i=0 ; i< size1 ; i++){
            temp1[i]  = nums[l+i];
        }
        for(int i=0 ; i< size2 ; i++){
            temp2[i]  = nums[m + i +1];
        }
        int i=0;
        int j =0;
        int k = l;
        while(i< size1 && j < size2 ){
            if(temp1[i]<= temp2[j]){
                nums[k] = temp1[i];
                k++;
                i++;
            }else if(temp1[i] > temp2[j]){
                nums[k] = temp2[j];
                k++;
                j++;
            }
        }

        while(i< size1){
            nums[k] = temp1[i];
            k++;
            i++;
        }
        while(j< size2){
            nums[k] = temp2[j];
            k++;
            j++;
        }
    }
}
