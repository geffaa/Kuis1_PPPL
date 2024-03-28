import org.example.Wallet;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WalletTest {

    private Wallet wallet;

    @BeforeAll
    public void initAll() {
        System.out.println("Initial Setup");
    }

    @BeforeEach
    public void init() {
        System.out.println("Setup a new wallet");
        wallet = new Wallet(100000, "IDR");
    }

    @Test
    @Order(1)
    public void testDepositAmount() {
        wallet.depositAmount(50000);
        assertEquals(150000, wallet.getBalance());
    }

    @Test
    @Order(2)
    public void testWithdrawAmount() {
        assertTrue(wallet.withdrawAmount(50000));
        assertEquals(100000, wallet.getBalance());
    }

    @Test
    @Order(3)
    public void testWithdrawAmountInsufficientFunds() {
        assertFalse(wallet.withdrawAmount(200000));
        assertEquals(100000, wallet.getBalance());
    }

    @Test
    @Order(4)
    public void testTransferFunds() {
        Wallet recipient = new Wallet(0, "IDR");
        wallet.transferFunds(recipient, 50000);
        assertEquals(50000, wallet.getBalance());
        assertEquals(50000, recipient.getBalance());
    }

    @Test
    @Order(5)
    public void testTransferFundsInsufficientFunds() {
        Wallet recipient = new Wallet(0, "IDR");
        assertThrows(IllegalArgumentException.class, () -> wallet.transferFunds(recipient, 100000));
    }

    @Test
    @Order(6)
    public void testTransferFundsDifferentCurrency() {
        Wallet recipient = new Wallet(0, "USD");
        assertThrows(IllegalArgumentException.class, () -> wallet.transferFunds(recipient, 50000));
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Cleaning up after the test");
        wallet = null;
    }

    @AfterAll
    public void tearDownAll() {
        System.out.println("All tests completed.");
    }
}