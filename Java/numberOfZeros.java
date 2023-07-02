
public static class numberOfZeros(int n)
{
    if(n == 0)
    {
        return 1;
    }
    else if(n < 10)
    {
        return 0;
    }
    else if(n%10 ==0)
    {
        return(numberOfZeros(n/10)+1);
    }
    else{
        return(numberOfZeros(n/10));
    }
}