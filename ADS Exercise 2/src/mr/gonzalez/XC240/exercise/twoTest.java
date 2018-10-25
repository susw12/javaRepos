package mr.gonzalez.XC240.exercise;

import static org.junit.jupiter.api.Assertions.*;

class twoTest {
    String method11q= "hello";
    String method11a = "olleh";
    String method12q = "Sujay";
    String method12a = "yajuS";
    int method21q = 1001;
    int method21a = 2;
    int method22q = 1234987012;
    int method22a = 37;
    int method31q = 39849;
    int method31a = 0;
    int method32q = 771829829;
    int method32a = 2;
    int method41q1 = 4;
    int method41q2 = 3;
    int method41a = 64;
    int method42q1 = 5;
    int method42q2 = 7;
    int method42a = 78125;
    int[] method51q = {10, 1, 20, 2, 30};
    boolean method51a = false;
    int[] method52q = {1,10, 2, 20, 30, 3};
    boolean method52a = true;
    int method61q1 = 9;
    int method61q2 = 6;
    int method61a = 3;
    int method62q1 = 5;
    int method62q2 = 6;
    int method62a = 1;
    String method71q = "person";
    int method71a = 2;
    String method72q = "yellow";
    int method72a = 2;
    String method81q = "tellet";
    int method81a = 1;
    String method82q = "adsfkjhk";
    int method82a = 0;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        method11q= "hello";
        method11a = "olleh";
        method12q = "Sujay";
        method12a = "yajuS";
        method21q = 1001;
        method21a = 2;
        method22q = 1234987012;
        method22a = 37;
        method31q = 39849;
        method31a = 0;
        method32q = 771829829;
        method32a = 2;
        method41q1 = 4;
        method41q2 = 3;
        method41a = 64;
        method42q1 = 5;
        method42q2 = 7;
        method42a = 78125;
        int[] method51q = {10, 1, 20, 2, 30};
        method51a = false;
        int[] method52q = {1,10, 2, 20, 30, 3};
        method52a = true;
        int method61q1 = 9;
        int method61q2 = 6;
        int method61a = 3;
        int method62q1 = 5;
        int method62q2 = 6;
        int method62a = 1;
        String method71q = "person";
        int method71a = 2;
        String method72q = "yellow";
        int method72a = 2;
        String method81q = "tellet";
        int method81a = 1;
        String method82q = "adsfkjhk";
        int method82a = 0;
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        method11q= null;
        method11a = null;
        method12q = null;
        method12a = null;
        method21q = 0;
        method21a = 0;
        method22q = 0;
        method22a = 0;
        method31q = 0;
        method31a = 0;
        method32q = 0;
        method32a = 0;
        method41q1 = 0;
        method41q2 = 0;
        method41a = 0;
        method42q1 = 0;
        method42q2 = 0;
        method42a = 0;
        int[] method51q = null;
        method51a = false;
        int[] method52q = null;
        method52a = false;
        int method61q1 = 0;
        int method61q2 = 0;
        int method61a = 0;
        int method62q1 = 0;
        int method62q2 = 0;
        int method62a = 0;
        String method71q = null;
        int method71a = 0;
        String method72q = null;
        int method72a = 0;
        String method81q = null;
        int method81a = 0;
        String method82q = null;
        int method82a = 0;

    }

    @org.junit.jupiter.api.Test
    void reverseString() {
        assertEquals(two.reverseString(method11q),method11a);
        assertEquals(two.reverseString(method12q), method12a);
    }

    @org.junit.jupiter.api.Test
    void sumDigits() {
        assertEquals(two.sumDigits(method21q), method21a);
        assertEquals(two.sumDigits(method22q), method22a);
    }

    @org.junit.jupiter.api.Test
    void count7() {
        assertEquals(two.count7(method31q), method31a);
        assertEquals(two.count7(method32q), method32a);
    }

    @org.junit.jupiter.api.Test
    void powerN() {
        assertEquals(two.powerN(method41q1, method41q2), method41a);
        assertEquals(two.powerN(method42q1, method42q2), method42a);
    }

    @org.junit.jupiter.api.Test
    void array220() {
        assertEquals(two.array220(method51q, 0), method51a);
        assertEquals(two.array220(method52q, 0), method52a);
    }

    @org.junit.jupiter.api.Test
    void euclideanGCD() {
        assertEquals(two.euclideanGCD(method61q1, method62q2), method61a);;
        assertEquals(two.euclideanGCD(method62q1, method62q2), method62a);
    }

    @org.junit.jupiter.api.Test
    void countVowel() {
        assertEquals(two.countVowel(method71q), method71a);
        assertEquals(two.countVowel(method72q), method72a);
    }

    @org.junit.jupiter.api.Test
    void isPalindrome() {
        assertEquals(two.isPalindrome(method81q), method81a);
        assertEquals(two.isPalindrome(method82q), method82a);
    }
}