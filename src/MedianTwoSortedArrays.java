/**
 * Created by xhu on 5/27/17.
 */
public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return -1;
        }

        int length1 = nums1.length;
        int length2 = nums2.length;

        if((length1+length2) %2 ==0){
            return findMedianSortedArraysHelper(nums1,nums2,0,0,(length1+length2)/2);
        }else{
            return (findMedianSortedArraysHelper(nums1,nums2,0,0,(length1+length2)/2) + findMedianSortedArraysHelper(nums1,nums2,0,0,(length1+length2)/2+1))/2;
        }


    }


    private int findMedianSortedArraysHelper(int[] nums1, int[] nums2, int start1, int start2, int k){

        if(start1>=nums1.length){
            return nums2[start2+k-1];
        }

        if(start2>=nums2.length){
            return nums1[start1+k-1];
        }

        if(k ==1){
            return Math.min(nums1[start1],nums2[start2]);
        }

        int media1 = start1+k-1>=nums1.length? Integer.MIN_VALUE : nums1[start1+k-1];
        int media2 = start2+k-1>=nums2.length? Integer.MIN_VALUE : nums2[start2+k-1];

        if(media1<media2){
            return findMedianSortedArraysHelper(nums1,nums2,start1+k/2,start2,k-k/2);
        }else{
            return findMedianSortedArraysHelper(nums1,nums2,start1,start2+k/2,k-k/2);
        }
    }
}
