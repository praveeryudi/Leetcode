package array;

public class _165_Compare_Version_Numbers {

    private static int compareVersion(String version1, String version2) {

        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");

        if(ver1.length == ver2.length && ver1.length == 0)
        {
            if(Integer.parseInt(version1) > Integer.parseInt(version2))
                return 1;
            if(Integer.parseInt(version1) < Integer.parseInt(version2))
                return -1;
            return 0;
        }

        int i = 0, j = 0;
        while(i < ver1.length && j < ver2.length) {
            String sub1 = ver1[i].replaceFirst("^0+(?!$)", "");
            String sub2 = ver2[j].replaceFirst("^0+(?!$)", "");

            if(Integer.parseInt(sub1) < Integer.parseInt(sub2))
                return -1;
            if(Integer.parseInt(sub1) > Integer.parseInt(sub2))
                return 1;
            i++;
            j++;
        }

        while(i < ver1.length) {
            int idx = 0;
            while(idx < ver1[i].length() && ver1[i].charAt(idx) == '0')
                idx++;
            String rem = ver1[i].substring(idx);
            if(!rem.isEmpty())
                return 1;
            i++;
        }

        while(j < ver2.length) {
            int idx = 0;
            while(idx < ver2[j].length() && ver2[j].charAt(idx) == '0')
                idx++;
            String rem = ver2[j].substring(idx);
            if(!rem.isEmpty())
                return -1;
            j++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.0.1";
        String version2 = "1";
        int res = compareVersion(version1, version2);
        System.out.println(res);
    }
}
