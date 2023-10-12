package day0_practice;

import org.junit.Test;
import utilities.TestBase;

public class P17_BasicAuthentications extends TestBase {

    @Test
    public void Test1() {

        // https://httpbin.org/basic-auth/foo/bar adresine gidin
        driver.get("https://httpbin.org/basic-auth/foo/bar");

        /// usarname: foo
        // pasword: bar
        driver.get("https://foo:bar@httpbin.org/basic-auth/foo/bar");
        // yukardaki verileri kullanarak guvenligi gecin.
    }
}
