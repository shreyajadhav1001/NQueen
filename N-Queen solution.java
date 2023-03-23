class Solution{
    static ArrayList<ArrayList<Integer>> ans;
    static boolean issafe(int [][]arr,int row,int col)
    {
        //vertically
        int n=arr.length;
        for(int i=row-1,j=col;i>=0;i--)
        {
            if(arr[i][j]==1)
            {
                return false;
            }
        }
        //left dia
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
        {
            if(arr[i][j]==1)
            {
                return false;
            }
        }
        //right dia
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++)
        {
            if(arr[i][j]==1)
            {
                return false;
            }
        }
        return true;
    }
    static void nqueen(int [][]arr,int row)
    {
        int n=arr.length;
        if(row==n)
        {
            printboard(arr);
            return;
        }
        
        {
        for(int col=0;col<n;col++)
        {
            if(issafe(arr,row,col))
            {
            arr[row][col]=1;
            nqueen(arr,row+1);
            arr[row][col]=0;
            }
        }
        }
    }
    static void printboard(int [][]arr)
    {
        int n=arr.length;
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<n ;i++)
        {
            for(int j=0;j<n ;j++)
        {
            if(arr[i][j]==1)
            {
                list.add(j+1);
            }
        }
        }
        ans.add(list);
    }
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ans=new ArrayList<ArrayList<Integer>>();
        int arr[][]=new int[n][n];
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         arr[i][j]=-1;
        //     }
        // }
        //ArrayList<Integer>op=new ArrayList<Integer>();
        nqueen(arr,0);
        return ans;
    }
}