package com.example.findchavrusa;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DatabaseConnectionTest {
    @Test
    public void addition_isCorrect() {
        DatabaseConnection db = new DatabaseConnection();

        db.testConnect();
    }
}