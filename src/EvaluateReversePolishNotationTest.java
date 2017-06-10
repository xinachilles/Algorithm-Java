import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 3/4/17.
 */
public class EvaluateReversePolishNotationTest {
    @Test
    public void evalRPN() throws Exception {
        EvaluateReversePolishNotation target = new EvaluateReversePolishNotation();
        target.evalRPN(new String[]{"18"});
    }

}