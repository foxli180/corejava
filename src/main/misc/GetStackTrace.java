package misc;

public class GetStackTrace {

    public static void main(String[] args) {

        callAnotherFunction();

    }

    private static void callAnotherFunction() {
        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();

        for (StackTraceElement stackTraceElement : stackTrace) {
            System.out.println(stackTraceElement.getMethodName());
        }
    }
}
