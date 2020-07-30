

import Service.DynaProxyHellp;
import Service.Helloimplements;
import Service.IHello;
import Service.StaticProxy;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.lang.System.*;

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}


public class Main {

    public static void main(String[] args) {

        int sum = 0;
        for (int i=0;i<10;i++)
        {
            sum+=i;
            out.println(i);
        }
        out.println(sum);

        // 静态代理
/*        Helloimplements hi = new Helloimplements();
        StaticProxy proxy = new StaticProxy();

        proxy.setImpl(hi);
        proxy.sayHello("Hello");*/

        // JDK 动态代理
        DynaProxyHellp helloproxy = new DynaProxyHellp();
        Helloimplements hello = new Helloimplements();
        IHello iHello =(IHello) helloproxy.bind(hello);
        iHello.sayHello("Jerry");

        // CGLIB 动态代理



        String greeting = "welcome to Core Java";
        out.println(greeting);
        for (int i=0;i<greeting.length();i++)
        {
            out.println("=");
        }


        out.println("Hello World!");

        // 取整操作
        int ss= 10/3;
        out.println(ss);

        int[] numbers= {2,4,7,9,10,15};
        out.println(biSearch(numbers,1));

        out.println(biSearch(numbers,0,numbers.length-1,3));

        int[] numberss={10,3,5,7,3,4,56,34};
        quickSort(numberss,0,numberss.length-1);
        out.println("快排排序后:");
        for (int i=0;i<numberss.length;i++)
        {
            out.println(numberss[i]);
        }

        int[] numberss1={10,3,5,7,3,4,56,34};
        selectOrder(numberss1);
        out.println("选择排序后:");
        for (int i=0;i<numberss1.length;i++)
        {
            out.println(numberss1[i]);
        }

        int[] numberss2={10,3,5,7,3,4,56,34};
        insertOrder(numberss2);
        out.println("插入排序后：");
        for (int i=0;i<numberss2.length;i++)
        {
            out.println(numberss2[i]);
        }

        int[] numberBubble={10,3,5,7,3,4,56,34};
        bubbleSort(numberBubble);
        out.println("冒泡排序后：");
        for (int i=0;i<numberBubble.length;i++)
        {
            out.println(numberBubble[i]);
        }

        double[][] darray= new double[10][];


        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("a","AA");
        hashMap.put("b","BB");
        hashMap.put("c","CC");

        out.println(hashMap);
        out.println(hashMap.get("a"));
        out.println(hashMap.containsKey("bb"));
        out.println(hashMap.remove("c"));

        //遍历HashMap 方案一
        Iterator it = hashMap.keySet().iterator();
        while (it.hasNext())
        {
            String key = (String)it.next();
            out.println(key);
            out.println(hashMap.get(key));
        }

        //遍历HashMap 方案二
        Iterator<Map.Entry<String,String>> it1 = hashMap.entrySet().iterator();
        while (it1.hasNext())
        {
            Map.Entry<String,String> me = it1.next();
            out.println(me.getKey());
            out.println(me.getValue());
        }

        //遍历HashMap 方案三
        for (Map.Entry<String,String> entry:hashMap.entrySet())
        {
            out.println("Item :"+entry.getKey()+" Value :" + entry.getValue());
        }

        //遍历HashMap 方案四
        for (String key : hashMap.keySet())
        {
            out.println("Item: "+key + " Value: "+hashMap.get(key));
        }

        //遍历HashMap 方案五
        hashMap.forEach((k,v)->out.println("Item："+k+" Value " +v));

        String strTest = "abcdefgabcdefg";
        char[] lst = strTest.toCharArray();


        Map<Character,Integer> map = new HashMap();
        for (char c: lst) {
            if (map.containsKey(c))
            {
                int value = (int) map.get(c);
                value++;
                map.put(c,value);
                continue;
            }
            map.put(c,1);
        }

        map.forEach((k,v)->out.println("Item: "+k+" Value: "+v));

        String[] charTest = strTest.split(".");
        for (int i = 0; i < charTest.length; i++) {
            out.println(charTest[i]+"\n");
        }

        // 抛出异常
        try {
            try {
                throw new Sneeze();
            } catch (Annoyance a) {
                out.println("caught annoyance");
                throw a;
            }
        } catch (Sneeze s) {
            out.println("caught sneeze");
            return;
        } finally {
            out.println("hello,world");
        }

    }


    public static int biSearch(int[] a,int number){
        int start =0;
        int end = a.length-1;
        while (start<=end)
        {
            int mid = (start+end)/2;
            if (a[mid] == number)
            {
                return mid+1;
            }
            else if (a[mid]>number)
            {
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return -1;
    }

    public static int biSearch(int[] a,int start,int end,int number)
    {
        int mid = (start+end)/2;
        if(start > end)
        {
            return -1;
        }
        if (a[mid]==number)
        {
            return mid+1;
        }
        else if (a[mid]>=number)
        {
            return biSearch(a,start,mid-1,number);
        }
        else
        {
            return biSearch(a,mid+1,end,number);
        }
    }

    // 快速排序 分治法 拆分
    public static void quickSort(int[] nums,int low, int high)
    {
        if (low<high)
        {
            int parIndex = partition(nums,low,high);
            quickSort(nums, 0,parIndex-1);
            quickSort(nums,parIndex+1,high);
        }
    }

    public static int partition(int[] nums,int low,int high)
    {
        int temp = nums[low];
        while (low<high)
        {
            while (low<high&&nums[high]>=temp)
            {
                high--;
            }
            nums[low]=nums[high];
            while(low<high&&nums[low]<=temp)
            {
                low++;
            }
            nums[high]=nums[low];
        }

        nums[low]=temp;

        return low;
    }

    // 选择排序
    public static void selectOrder(int[] nums)
    {
        for (int i =0 ;i<nums.length-1;i++)
        {
            int min=i;

            for (int j=i+1;j<nums.length;j++)
            {
                if (nums[min]>nums[j]) {

                    int temp = nums[j];
                    nums[j]=nums[min];
                    nums[min]=temp;
                }
            }
        }
    }

    // 插入排序
    public static void insertOrder(int[] nums)
    {
        for (int i=1;i<nums.length;i++)
        {
            int temp=nums[i];
            int k = i;

            // 找到就替换
//            while (k>0)
//            {
//                if (nums[k-1]>nums[k])
//                {
//                    insertSwap(nums,k,k-1);
//                }
//                k--;
//            }

            // 找到统一替换 不使用中间变量
            while (k>0 && nums[k-1]>=nums[k])
            {
                k--;
            }

            for (int j = i;j>k;j--)
            {
                nums[j]=nums[j-1];
            }

            nums[k]=temp;
        }
    }

    public static void insertSwap(int[] nums,int start,int end)
    {
        int temp = nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
    }

    public static void bubbleSort(int[] nums)
    {
        for (int i=0;i<nums.length-1;i++)
        {
            for (int j =0;j<nums.length-i-1;j++)
            {
                if (nums[j]>nums[j+1])
                {
                    insertSwap(nums,j,j+1);
                }
            }
        }
    }

    public static int[] bitmapSort(int[] arr)
    {
        // 找出最大值最小值
        int max = arr[0];
        int min = max;
        for (int i: arr) {
            if (max<i)
            {
                max = i;
            }
            if (min > i)
            {
                min = i;
            }
        }

        // 初始位图数组大小
        int temp = 0;
        int[] newArr = null;
        if (min < 0)
        {
            temp = 0 - min;
            newArr = new int[max-min+1];
        }
        else
        {
            newArr = new int[max+1];
            min =0;
        }

        //构建位图 向右偏移
        for (int i: arr) {
            newArr[i+temp]++;
        }

        // 重新调整arr数组中的元素
        int index =0;
        for (int i=0;i<newArr.length;i++)
        {
            // 位图是1的就输出
            while (newArr[i]>0)
            {
                arr[index]=i+min;
                index++;
                newArr[i]--;
            }
        }

        return  arr;
    }

}
