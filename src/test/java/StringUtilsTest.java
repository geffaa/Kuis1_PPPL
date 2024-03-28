import org.example.StringUtils;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringUtilsTest {

    private StringUtils stringUtils;

    @BeforeAll
    public void initAll() {
        System.out.println("Initial setup");
    }

    @BeforeEach
    public void init() {
        System.out.println("Setup before each");
        stringUtils = new StringUtils();
    }

    @Test
    @Order(1)
    public void testReverseString() {
        assertEquals("samihd", stringUtils.reverseString("dhimas"));
        assertNull(stringUtils.reverseString(null));
    }

    @Test
    @Order(2)
    public void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("radar"));
        assertFalse(stringUtils.isPalindrome("hello"));
        assertFalse(stringUtils.isPalindrome(null));
    }

    @Test
    @Order(3)
    public void testCountVowels() {
        assertEquals(2, stringUtils.countVowels("hello"));
        assertEquals(0, stringUtils.countVowels(null));
    }

    @Test
    @Order(4)
    public void testReverseStringWithString() {
        assertEquals("hahahaha", stringUtils.reverseString("ahahahah"));
    }

    @Test
    @Order(5)
    public void testIsPalindromeWithNumbers() {
        assertTrue(stringUtils.isPalindrome("121"));
        assertFalse(stringUtils.isPalindrome("123"));
    }

    @Test
    @Order(6)
    public void testCountVowelsInEmptyString() {
        assertEquals(0, stringUtils.countVowels(""));
    }

    @Test
    @Order(7)
    public void testCountVowelsInStringWithNumbers() {
        assertEquals(2, stringUtils.countVowels("haha1234"));
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Cleaning up after the test");
        stringUtils = null;
    }

    @AfterAll
    public void tearDownAll() {
        System.out.println("All tests completed.");
    }
}