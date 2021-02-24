
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        BigInt b = new BigInt();
        b.test();

    }
}


class BigInt{

    private byte[] mtab;

    BigInt(){}

    BigInt(String str)
    {
        mtab = new byte[str.length()];
        for(int i=0;i<str.length();i++)
            mtab[i] = (byte)(Character.getNumericValue(str.charAt(i)));

    }

    BigInt(byte[] tab)
    {
        mtab = tab.clone();
    }

    BigInt(BigInt bg)
    {
        mtab = bg.getNum();
    }


    @Override
    public boolean equals(Object obj)
    {
        if(obj == this)
            return true;

        if(!(obj instanceof BigInt))
            return false;

        BigInt b = (BigInt) obj;

        if(this.getLength() != b.getLength())
            return false;

        for(int i=0;i<this.getLength();i++)
        {
            if(b.getNum()[i]!=mtab[i])
                return false;
        }
        return true;

    }

    @Override
    public String toString()
    {
        String tmp = "";
        for (byte b : mtab) {
            tmp += b;
        }
        return tmp;
    }

    public byte[] getNum()
    {
        return mtab;
    }
    public int getLength()
    {
        return mtab.length;
    }


    BigInt add(BigInt other)
    {
        String s1 = this.toString();
        String s2 = other.toString();
        String res = "";
        int tmp = 0;
        int size1 = s1.length();
        int size2 = s2.length();


        if(s1.length()>s2.length()){
            String tmp2 = s1;
            s1 = s2;
            s2 = tmp2;
        }

        s1 = new StringBuilder(s1).reverse().toString();
        s2 = new StringBuilder(s2).reverse().toString();

        for(int i=0;i<size1;i++)
        {
            int sum = (s1.charAt(i) - '0') +
                    (s2.charAt(i) - '0') + tmp;
            res += (char)(sum % 10 + '0');

            tmp = sum / 10;
        }

        for(int i=size1;i<size2;i++)
        {
            int sum = (s2.charAt(i) - '0') + tmp;
            res += (char)(sum % 10 + '0');
            tmp = sum / 10;
        }

        if(tmp>0)
            res += (char)(tmp + '0');

        res = new StringBuilder(res).reverse().toString();

        return new BigInt(res);
    }


    public void test() {

        int testpassed=0;

        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            long p = (random.nextLong())%1000000;
            long q = (random.nextLong())%1000000;
            if(p<0)
                p *= -1;
            if(q<0)
                q *= -1;


            BigInt bg1 = new BigInt(String.valueOf(p));
            BigInt bg2 = new BigInt(String.valueOf(q));
            BigInt res_counted = bg1.add(bg2);

            BigInt res = new BigInt(String.valueOf(p+q));

            if(res.equals(res_counted))
                testpassed++;

        }
        System.out.println("Tests passed = " + testpassed);

    }


}



