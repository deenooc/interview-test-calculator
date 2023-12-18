# interview-test-calculator

The integration test class `nz.co.interview.calculator.ITCalculator` shows how the calculator works.

To run the calculator application, run the `nz.co.interview.App`.

**1. Supported operations:**
- 1.1. Addition
- 1.2. Subtraction
- 1.3. Multiplication
- 1.4. Division
- 1.5. Operation ::= ‘+’ | ‘-’ | ‘*’ | ‘/’

**2. Operands**
- 2.1. Operand ::= [0-9]+[.]?[0-9]*
- 2.2. No thousand separators (i.e., ,)

**3. Inputs**
-  3.1 Input ::= Operand ‘ ‘ Operation ‘ ‘ Operand

**4. Outputs**
-  4.1. The result is printed to the console